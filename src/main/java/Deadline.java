import java.time.LocalDateTime;

public class Deadline extends Task{
    private LocalDateTime deadline;

    public Deadline(String name, LocalDateTime deadline) {
        super(name);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D]" + getStatusIcon() + " " + getName();
    }
}
