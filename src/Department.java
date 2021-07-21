import java.util.*;

public class Department {
    private String name;
    private Manager departmentManager;
    private List<Employee> employeeList;

    public Department(String name, Manager departmentManager, List<Employee> employeeList) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.departmentManager = Objects.requireNonNull(departmentManager, "Department manager cannot be null");
        this.employeeList = Objects.requireNonNull(employeeList, "Employee list cannot be null");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
    }

    public Manager getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(Manager departmentManager) {
        this.departmentManager = Objects.requireNonNull(departmentManager, "Department manager cannot be null");
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = Objects.requireNonNull(employeeList, "Employee list cannot be null");
    }
}
