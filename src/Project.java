import java.util.*;
import java.time.*;

public class Project {
    private LocalDate startDate;
    private LocalDate deadLine;
    private List<Employee> projectMembers;
    private List<Department> involvedDepartments;


    public Project(LocalDate startDate, LocalDate deadLine, List<Employee> projectMembers, List<Department> involvedDepartments) {
        this.startDate = Objects.requireNonNull(startDate, "Start date cannot be null");
        this.deadLine = Objects.requireNonNull(deadLine, "Deadline cannot be null");
        this.projectMembers = Objects.requireNonNull(projectMembers, "Project members list cannot be null");
        this.involvedDepartments = Objects.requireNonNull(involvedDepartments, "Involved departments list cannot be null");
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = Objects.requireNonNull(startDate, "Start date cannot be null");
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = Objects.requireNonNull(deadLine, "Deadline cannot be null");
    }

    public List<Employee> getProjectMembers() {
        return projectMembers;
    }

    public void setProjectMembers(List<Employee> projectMembers) {
        this.projectMembers = Objects.requireNonNull(projectMembers, "Project members list cannot be null");
    }

    public List<Department> getInvolvedDepartments() {
        return involvedDepartments;
    }

    public void setInvolvedDepartments(List<Department> involvedDepartments) {
        this.involvedDepartments = Objects.requireNonNull(involvedDepartments, "Involved departments list cannot be null");
    }
}
