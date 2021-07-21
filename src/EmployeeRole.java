import java.util.Objects;

public class EmployeeRole {
    public enum Role {
        DEVELOPER("Developer", 4000),
        TESTER("Tester", 3500),
        SUPPORT_ENGINEER("Support engineer", 2500),
        PROJECT_MANAGER("Project manager", 6000);

        public String roleName;
        public int baseSalary;

        private Role(String roleName, int baseSalary) {
            this.roleName = roleName;
            this.baseSalary = baseSalary;
        }
    }

    private Role role;

    public EmployeeRole(Role role) {
        this.role = Objects.requireNonNull(role, "Role cannot be null");
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = Objects.requireNonNull(role, "Role cannot be null");
    }
}
