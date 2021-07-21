import java.time.*;
import java.util.*;

public class ApplicationRunner {
    private static OperationsManager operationsManager = new OperationsManager();

    public static void main(String[] args) {
        //Roles
        EmployeeRole employeeRole1 = new EmployeeRole(EmployeeRole.Role.DEVELOPER);
        EmployeeRole employeeRole2 = new EmployeeRole(EmployeeRole.Role.TESTER);
        EmployeeRole employeeRole3 = new EmployeeRole(EmployeeRole.Role.SUPPORT_ENGINEER);
        EmployeeRole employeeRole4 = new EmployeeRole(EmployeeRole.Role.PROJECT_MANAGER);

        //Managers
        Manager directManager1 = new Manager("Jack");
        Manager directManager2 = new Manager("George");
        Manager directManager3 = new Manager("David");

        //Holidays
        Holiday holiday1 = new Holiday(LocalDate.parse("2021-04-10"), LocalDate.parse("2021-04-29"));
        Holiday holiday2 = new Holiday(LocalDate.parse("2021-10-10"), LocalDate.parse("2021-10-29"));
        List<Holiday> holidays1 = new ArrayList<>(Arrays.asList(holiday1, holiday2));

        Holiday holiday3 = new Holiday(LocalDate.parse("2021-06-15"), LocalDate.parse("2021-06-30"));
        Holiday holiday4 = new Holiday(LocalDate.parse("2021-02-10"), LocalDate.parse("2021-02-10"));
        List<Holiday> holidays2 = new ArrayList<>(Arrays.asList(holiday3, holiday4));

        //Employees
        Employee emp1 = new Employee("Jim", employeeRole1, LocalDate.parse("2001-05-01"),directManager1,holidays1);
        Employee emp2 = new Employee("Josh",employeeRole2, LocalDate.parse("2010-07-01"), directManager2, holidays1);
        Employee emp3 = new Employee("Gary",employeeRole2, LocalDate.parse("2010-07-01"), directManager3, holidays1);
        Employee emp4 = new Employee("Steven",employeeRole2, LocalDate.parse("2010-07-01"), directManager3, holidays2);
        Employee newEmp = new Employee("Andrew", employeeRole1,LocalDate.parse("2015-05-01"),directManager1,holidays1);

        List<Employee> employeeList1 = new ArrayList<>(Arrays.asList(emp1, emp2, emp3, emp4));
        List<Employee> employeeList2 = new ArrayList<>(Arrays.asList(emp1, emp2));
        List<Employee> employeeList3 = new ArrayList<>(Arrays.asList(emp1, emp2, emp3));

        //Departments
        Department department1 = new Department("Engineering", directManager1, employeeList1);
        Department department2 = new Department("Sales", directManager3, employeeList2);
        Department department3 = new Department("Customer success", directManager2, employeeList3);

        List<Department> departmentList1 = new ArrayList<>(Arrays.asList(department1, department2, department3));
        List<Department> departmentList2 = new ArrayList<>(Arrays.asList(department1, department3));


        //Projects
        Project project1 = new Project(LocalDate.parse("2021-03-01"), LocalDate.parse("2021-09-01"), employeeList1, departmentList1);
        Project project2 = new Project(LocalDate.parse("2021-06-01"), LocalDate.parse("2021-10-01"), new ArrayList<Employee>(), departmentList2);
        List<Project> projectList1 = new ArrayList<>(Arrays.asList(project1, project2));


        //Calculating salary for employee Jim
        System.out.println("SALARY CALCULATION: ");
        System.out.println(operationsManager.calculateSalary(emp1));

        //Assigning available employees to project2(2021-06-01 -> 2021-10-01)
        System.out.println();
        operationsManager.assignAvailableEmployees(project2, employeeList1);
        System.out.println("Assigned to project:");
        project2.getProjectMembers().stream().forEach(x -> System.out.println(String.format("Employee name: %s; Employee role: %s; Employment date: %s; Direct manager: %s",
                x.getName(), x.getEmployeeRole().getRole().roleName, x.getEmploymentDate(), x.getDirectManager().getName())));

        System.out.println();
        System.out.println("EMPLOYEE DISPLAY:");
       operationsManager.printEmployees(department1);

        System.out.println();
        System.out.println("DEPARTMENTS DISPLAY:");
        operationsManager.getDepartments(project2).stream().forEach(x -> System.out.println(String.format("Department name: %s; Department manager: %s", x.getName(), x.getDepartmentManager().getName())));

        //Swapping employee Gary with new employee Andrew
        System.out.println();
        System.out.println("BEFORE SWAP:");
        operationsManager.printEmployees(department1);
        operationsManager.printEmployees(department2);
        operationsManager.printEmployees(department3);

        System.out.println();
        System.out.println("AFTER SWAP:");
        operationsManager.swapEmployees(emp3, newEmp, departmentList1, projectList1);
        operationsManager.printEmployees(department1);
        operationsManager.printEmployees(department2);
        operationsManager.printEmployees(department3);


    }




}
