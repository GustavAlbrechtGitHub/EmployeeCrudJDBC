import java.sql.SQLException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws SQLException {

        Utilities uInput = new Utilities();

        UI io = new UI(uInput);

        EmployeeDaoJDBCImpl edao = new EmployeeDaoJDBCImpl();

        EmployeeController ec = new EmployeeController(uInput, io, edao);

        ec.runEmployeeManagementProgram();


    }

}
