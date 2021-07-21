import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OperationsManager {

    public int calculateSalary(Employee employee) {
        if (employee == null) {
            return -1;
        }
        EmployeeRole employeeRole = employee.getEmployeeRole();
        int baseSalary = employeeRole.getRole().baseSalary;
        int seniority = LocalDate.now().getYear() - employee.getEmploymentDate().getYear();

        return baseSalary * seniority;
    }

    public void assignAvailableEmployees(Project project, List<Employee> employeeList) {
        if (project == null || employeeList == null) {
            return;
        }
        //Retrieving the start and end date for the project
        LocalDate startDate = project.getStartDate();
        LocalDate endDate = project.getDeadLine();

        //If all the employee holidays are outside the timeframe of the project then he is assigned to it otherwise his description is printed to the console
        for (Employee employee : employeeList) {
            List<Holiday> holidayList = employee.getYearlyHolidays();
            boolean canAssign = true;
            for (Holiday holiday : holidayList) {
                if (!isAvailable(startDate, endDate, holiday)){
                    canAssign = false;
                    break;
                }
            }

            if (canAssign) {
                project.getProjectMembers().add(employee);
            } else {
                System.out.println("Unavailable employee/s for project:");
                System.out.println(String.format("Employee name: %s; Employee role: %s; Employment date: %s; Direct manager: %s",
                        employee.getName(), employee.getEmployeeRole().getRole().roleName, employee.getEmploymentDate(), employee.getDirectManager().getName()));

            }
        }

    }

    //Method for checking the employee availability based on the provided start and end date of the project and current holiday
    private boolean isAvailable(LocalDate startDate, LocalDate endDate, Holiday holiday) {
        if (startDate == null || endDate == null || holiday == null) {
            return false;
        }

        if (holiday.getStartDate().isBefore(startDate) && holiday.getEndDate().isBefore(startDate)){
            return true;
        } else if (holiday.getStartDate().isAfter(endDate) && holiday.getEndDate().isAfter(startDate)) {
            return true;
        }

        return false;
    }

    //Method for printing the employees of a department
    public void printEmployees(Department department) {
        if (department == null) {
            return;
        }

        System.out.println(department.getName());
        for (Employee employee : department.getEmployeeList()) {
            System.out.println(String.format("Employee name: %s; Employee role: %s; Employment date: %s; Direct manager: %s",
                    employee.getName(), employee.getEmployeeRole().getRole().roleName, employee.getEmploymentDate(), employee.getDirectManager().getName()));

        }
    }

    //Method for returning the list containing the departments involved in a project
    public List<Department> getDepartments(Project project) {
        if (project == null) {
            return new ArrayList<Department>();
        }

        return project.getInvolvedDepartments();
    }

    //Method for replacing the leaving employee with the new employee
    public void swapEmployees(Employee leavingEmployee, Employee replacementEmployee, List<Department> departmentList, List<Project> projectList) {
        //Sets the direct manager of the replacement employee to be the same as the leaving employee's manager
        replacementEmployee.setDirectManager(leavingEmployee.getDirectManager());

        //Replaces the leaving employee in all the departments where he is found
        for (Department department : departmentList) {
            List<Employee> temp = department.getEmployeeList();
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).getName().equals(leavingEmployee.getName())) {
                    temp.set(i, replacementEmployee);
                }
            }
        }

        //Replaces the leaving employee in all the projects where he is found
        for (Project project : projectList) {
            List<Employee> temp = project.getProjectMembers();
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).getName().equals(leavingEmployee.getName())) {
                    temp.set(i, replacementEmployee);
                }
            }
        }
    }
}
