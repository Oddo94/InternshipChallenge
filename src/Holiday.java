import java.time.*;
import java.util.Objects;

public class Holiday {
    private LocalDate startDate;
    private LocalDate endDate;

    public Holiday(LocalDate startDate, LocalDate endDate) {
        this.startDate = Objects.requireNonNull(startDate, "Start date cannot be null");
        this.endDate = Objects.requireNonNull(endDate, "End date cannot be null");
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = Objects.requireNonNull(startDate, "Start date cannot be null");
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = Objects.requireNonNull(endDate, "End date cannot be null");
    }
}
