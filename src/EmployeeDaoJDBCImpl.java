import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoJDBCImpl implements EmployeeDao {

    String url = "jdbc:mysql://localhost:3306/test";

    String userName = "root";

    String userPassWord = "root";

    Connection connection;

    PreparedStatement insert, findByFirstName, findByLastName, findByBirthday, findById, findBySalary, findByDepartment,  findAll, delete, update;



    public EmployeeDaoJDBCImpl() {
        try {

            // Class.forName("com.mysql.jdbc.Driver");


            connection = DriverManager.getConnection(url, userName, userPassWord);

            insert = connection.prepareStatement("INSERT INTO employeetable (firstname, lastname, birthday, salary, department) VALUES (?, ?, ?, ?, ?)");

            findByFirstName = connection.prepareStatement("SELECT * FROM employeetable WHERE firstname like ?");

            findByLastName = connection.prepareStatement("SELECT * FROM employeetable WHERE lastname LIKE ?");

            findByBirthday = connection.prepareStatement("SELECT * FROM employeetable WHERE birthday >= ? AND birthday <= ?");

            findById = connection.prepareStatement("SELECT * FROM employeetable WHERE id = ?");

            findBySalary = connection.prepareStatement("SELECT * FROM employeetable WHERE salary = ?");

            findByDepartment = connection.prepareStatement("SELECT * FROM employeetable WHERE department = ?");

            findAll = connection.prepareStatement("SELECT * FROM employeetable");

            update = connection.prepareStatement("UPDATE employeetable SET firstname = ?, lastname = ?  WHERE id = ?");

            delete = connection.prepareStatement("DELETE FROM employeetable WHERE id = ?");



        } catch ( SQLException e){ //ClassNotFoundException  |

            throw new RuntimeException("EmployeeDao constructor problem: " + e);

        }
    }


    @Override
    public boolean create(String firstname, String lastname, int birthday, double salary, String department) {
        try {
            insert.setString(1, firstname);
            insert.setString(2, lastname);
            insert.setInt(3, birthday);
            insert.setDouble(4, salary);
            insert.setString(5, department);

            int antalRader = insert.executeUpdate();

            if (antalRader > 0){
                return true;
            }
            else return false;

        }
        catch (SQLException e) {
            throw new RuntimeException("EmployeeDao created problem " + e);
        }

    }

    private List<Employee> listFromStatement (PreparedStatement stmt) throws SQLException {
        List<Employee> list = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();

        if (rs.next() == false){
            System.out.println("Wasnt found in the table");
        }
        else {
            do{
                list.add(new Employee(rs.getInt("id"), rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getInt("birthday"), rs.getDouble("salary"),  rs.getString("department")));
            } while(rs.next());



        }


        return list;

    }

    @Override
    public List<Employee> getAll() {
        try {
            return listFromStatement(findAll);
        }
        catch (SQLException e) {
            throw new RuntimeException("EmployeeDao findAll problem: " + e);
        }

    }



    @Override
    public List<Employee> getByFirstName(String firstName) {

        try {

            findByFirstName.setString(1, firstName + "%");

            return listFromStatement(findByFirstName);

        }
        catch (SQLException e){

            throw new RuntimeException("EmployeeDao findByFirstName problem " + e);
        }

    }

    @Override
    public List<Employee> getByLastName(String lastName) {


        try {
            findByLastName.setString(1, lastName + "%");
            return listFromStatement(findByLastName);
        }
        catch (SQLException e){
            throw new RuntimeException("EmployeeDao findByLastName problem " + e);
        }
    }

    @Override
    public List<Employee> getByBirthday(int start, int end) {


        try {
            findByBirthday.setInt(1, start);
            findByBirthday.setInt(2, end);
            return listFromStatement(findByBirthday);
        }
        catch (SQLException e){
            throw new RuntimeException("EmployeeDao findByBirth " + e);
        }
    }



    @Override
    public Employee getById(int id) {


        try {
            findById.setInt(1, id);
            List<Employee> list = listFromStatement(findById);
            if (list.size() > 0) return list.get(0);
            else return null;
        } catch (SQLException e){
            throw new RuntimeException("EmployeeDao findById problem: " + e);
        }
    }

    @Override
    public List<Employee> getBySalary(double salary) {

        try {
            findBySalary.setDouble(1, salary);

            return listFromStatement(findBySalary);
        }
        catch (SQLException e){
            throw new RuntimeException("EmployeeDao findBySalary " + e);
        }
    }

    @Override
    public List<Employee> getByDepartment(String department) {

        try {
            findByDepartment.setString(1, department);
            return listFromStatement(findByDepartment);
        }
        catch (SQLException e){
            throw new RuntimeException("EmployeeDao findByDepartment problem " + e);
        }
    }

    @Override
    public boolean update(String firstName, String lastName, int id) {

        try {
            update.setString(1, firstName);
            update.setString(2, lastName);
            update.setInt(3, id);
            if (update.executeUpdate() > 0) return true;
            else return false;
        }
        catch (SQLException e) {
            throw new RuntimeException("EmployeeDao update problem " + e);

        }
    }

    @Override
    public boolean delete(int id) {

        try {
            delete.setInt(1, id);
            if (delete.executeUpdate() > 0) return true;
            else return false;
        }
        catch (SQLException e){
            throw new RuntimeException(("EmployeeDao delete problem " + e));
        }
    }


}
