public class UI implements UIInterface {

    Utilities uInput;

    public UI(Utilities uInput) {
        this.uInput = uInput;
    }

    public void showManagementMenu() {
        System.out.println("""
                _______________________________________________
                              Employee Management
                _______________________________________________
                1. Add Employee To Database
                2. Show All Employees in Database
                3. Update Employee
                4. Get Employee By Firstname
                5. Get Employee By Lastname
                6. Get Employee By Birthday
                7. Get Employee By Id
                8. Get Employee By Salary
                9. Get Employee By Department
                10. Delete Employee From Database
                0. Exit
                        
                Please choose: """);
    }

    public UI() {

    }

    public Employee readEmployee() {

        Employee e = new Employee();


        System.out.print("Enter First Name: ");
        e.setFirstname(uInput.getStringInput());

        System.out.print("Enter Last Name: ");
        e.setLastname(uInput.getStringInput());

        System.out.print("Enter birthday(YYYYMMDD****): ");
        e.setBirthday(uInput.getIntInput());

        System.out.print("Enter salary: ");
        e.setSalary(uInput.getDoubleInput());

        e.setDepartment(enterDepartment());

        return e;

    }

    public String enterDepartment() {

        String department = "";

        System.out.println("Please enter department");
        System.out.println("1.DBAdmin, 2.Developer, 3.Technician, 4.Marketing, 5.Secretary, 6.Web Designer 7. Chief");
        String choiceDepartment = uInput.getStringInput();

        switch (choiceDepartment) {
            case "1" -> department = "DBAdmin";
            case "2" -> department = "Developer";
            case "3" -> department = "Technician";
            case "4" -> department = "Marketing";
            case "5" -> department = "Secretary";
            case "6" -> department = "Web Designer";
            case "7" -> department = "Chief";
            default -> System.out.println("Wrong input, please choose option 1-7.");
        }

        return department;
    }

    public void printEmployeeBeenAdded() {

        System.out.println("Employee has been added to database! ");
    }

    public void printEmployeeBeenUpdated() {

        System.out.println("Employee has been updated!");

    }

    public void printEmployeeBeenDeleted() {

        System.out.println("Employee has been deleted!");
    }

    public String getByFirstNameEmployeeIO() {

        System.out.println("Please enter firstname: ");

        return uInput.getStringInput();

    }

    public String getByLastNameEmployeeIO() {

        System.out.println("Please enter lastname: ");

        return uInput.getStringInput();
    }

    public int getByBirthdayEmployeeIOStart() {


        System.out.println("Please enter range of birthday for database: ");
        System.out.println("(8 numbers)");
        System.out.print("Start: ");

        return uInput.getIntInput();

    }

    public int getByBirthdayEmployeeIOEnd() {

        System.out.print("End: ");
        return uInput.getIntInput();

    }

    public int getByIdEmployeeIO() {

        System.out.println("Please enter id: ");

        return uInput.getIntInput();

    }

    public double getBySalaryEmployeeIO() {

        System.out.println("Please enter salary: ");

        return uInput.getDoubleInput();

    }

    public int deleteEmployeeIO() {

        System.out.println("Please enter id of employee you want to delete:");

        return uInput.getIntInput();

    }
}
