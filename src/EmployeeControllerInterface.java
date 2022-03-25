import java.util.List;

public interface EmployeeControllerInterface {

    public void runEmployeeManagementProgram();

    public void addEmployee();

    public void showAllEmployees();

    public void getByFirstNameEmployeeController();

    public void printList(List<Employee> list);

    public void printEmployee(Employee e);

    public void getByLastNameEmployeeController();

    public void getByBirthdayEmployeeController();

    public void getByIdEmployeeController();

    public void getBySalaryEmployeeController();

    public void getByDepartmentEmployeeController();

    public void updateEmployee();

    public void deleteEmployeeController();


}
