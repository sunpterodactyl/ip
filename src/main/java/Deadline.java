//remove local date time for now since there is no consistent format
public class Deadline extends Task{
    String deadline;

    public Deadline(String name, String deadline) {
        super(name);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D]" + getStatusIcon() + " " + getName() + "(by: " + deadline +")";
        //TODO: Date Time Formatter
    }
}
