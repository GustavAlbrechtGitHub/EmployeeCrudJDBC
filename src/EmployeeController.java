import java.sql.SQLException;
import java.util.List;

public class EmployeeController implements EmployeeControllerInterface{

    Utilities uInput;

    UI io;

    EmployeeDaoJDBCImpl edao;

    public EmployeeController(Utilities uInput, UI io, EmployeeDaoJDBCImpl edao) {
        this.uInput = uInput;
        this.io = io;
        this.edao = edao;
    }


    @Override
    public void runEmployeeManagementProgram() {

        boolean mainLoop = true;

        while (mainLoop) {

            io.showManagementMenu();

            String choice = uInput.getStringInput();


            switch (choice) {

                case "1" -> addEmployee();
                case "2" -> showAllEmployees();
                case "3" -> updateEmployee();
                case "4" -> getByFirstNameEmployeeController();
                case "5" -> getByLastNameEmployeeController();
                case "6" -> getByBirthdayEmployeeController();
                case "7" -> getByIdEmployeeController();
                case "8" -> getBySalaryEmployeeController();
                case "9" -> getByDepartmentEmployeeController();
                case "10" -> deleteEmployeeController();
                case "0" -> mainLoop = false;
                default -> System.out.println("Wrong input, please choose 1-9");
            }
        }
    }


    @Override
    public void addEmployee() {

        Employee e = io.readEmployee();




        edao.create(e.getFirstname(), e.getLastname(), e.getBirthday(), e.getSalary(), e.getDepartment());


    }

    @Override
    public void showAllEmployees(){

        printList(edao.getAll());
    }

    @Override
    public void getByFirstNameEmployeeController() {


       String firstName = io.getByFirstNameEmployeeIO();

        printList(edao.getByFirstName(firstName));



    }

    @Override
    public void printList(List<Employee> list){
        list.forEach(System.out::println);

    }

    @Override
    public void printEmployee(Employee e){

        System.out.println(e);

    }


    @Override
    public void getByLastNameEmployeeController() {


        String lastName = io.getByLastNameEmployeeIO();

        printList(edao.getByLastName(lastName));

    }

    @Override
    public void getByBirthdayEmployeeController() {

        // fråga bita dubbel string


        int start = io.getByBirthdayEmployeeIOStart();

        int end = io.getByBirthdayEmployeeIOEnd();

        printList(edao.getByBirthday(start, end));


    }



    @Override
    public void getByIdEmployeeController() {



        int id = io.getByIdEmployeeIO();

        printEmployee(edao.getById(id));


    }

    @Override
    public void getBySalaryEmployeeController() {


        double salary = io.getBySalaryEmployeeIO();

       printList(edao.getBySalary(salary));


    }

    @Override
    public void getByDepartmentEmployeeController() {

        String department = io.enterDepartment();

        printList(edao.getByDepartment(department));


    }

    @Override
    public void updateEmployee() {



        String firstName = io.getByFirstNameEmployeeIO();


        String lastName = io.getByLastNameEmployeeIO();


        int id = io.getByIdEmployeeIO();

        edao.update(firstName, lastName, id);




    }

    @Override
    public void deleteEmployeeController() {


        int id = io.deleteEmployeeIO();

        edao.delete(id);




    }


}



