import java.util.*;
import java.time.*;

public class Employee {
    private String name;
    private EmployeeRole role;
    private LocalDate employmentDate;
    private Manager directManager;
    private List<Holiday> yearlyHolidays;


    public Employee (String name, EmployeeRole role, LocalDate employmentDate, Manager directManager, List<Holiday> yearlyHolidays) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.role = Objects.requireNonNull(role, "Role cannot be null");
        this.employmentDate = Objects.requireNonNull(employmentDate, "Employment date cannot be null");
        this.directManager = Objects.requireNonNull(directManager, "Direct manager cannot be null");
        this.yearlyHolidays = Objects.requireNonNull(yearlyHolidays, "Yearly holidays list cannot be null");
    }


    public String getName() {
        return this.name;
    }

    public EmployeeRole getEmployeeRole() {
        return role;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public Manager getDirectManager() {
        return directManager;
    }

    public List<Holiday> getYearlyHolidays() {
        return yearlyHolidays;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
    }
    public void setRole(EmployeeRole role) {
        this.role = Objects.requireNonNull(role, "Role cannot be null");
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = Objects.requireNonNull(employmentDate, "Employment date cannot be null");
    }

    public void setDirectManager(Manager directManager) {
        this.directManager = Objects.requireNonNull(directManager, "Direct manager cannot be null");
    }

    public void setYearlyHolidays(ArrayList<Holiday> yearlyHolidays) {
        this.yearlyHolidays = Objects.requireNonNull(yearlyHolidays, "Yearly holidays list cannot be null");
    }
}
