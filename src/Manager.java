import java.util.*;

public class Manager {
    private String name;


    public Manager(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
    }
}
