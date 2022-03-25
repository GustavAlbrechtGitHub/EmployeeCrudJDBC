import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

    public boolean create(String firstname, String lastname, int birthday, double salary, String department);

    public List<Employee> getAll();

    public  List<Employee> getByFirstName(String firstname);

    public List<Employee> getByBirthday(int start, int end);

    public List<Employee> getByLastName(String lastName);

    public Employee getById(int id);

    public List<Employee> getBySalary(double salary);

    public List<Employee> getByDepartment(String department);

    public boolean update(String firstName, String lastName, int id);

    public boolean delete(int id);
}
