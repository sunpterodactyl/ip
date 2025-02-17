package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
Deadline type of task
 Has a due date
 */
public class Deadline extends Task {
    protected LocalDateTime deadline;
    static DateTimeFormatter formatFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Deadline(String name, String deadline, long priority) {
        super(name, priority);
        this.deadline = parseDate(deadline);
    }

    public static LocalDateTime parseDate(String dateStr) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        return LocalDateTime.parse(dateStr, formatter);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + deadline.format(formatFormatter) +")";
    }

    @Override
    public String toStorageString() {
        return "[D]" + getDescription()  + deadline;
    }
}
