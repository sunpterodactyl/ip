package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Event class - contains a start and end date
 */
public class Event extends Task {

    private LocalDateTime start;
    private LocalDateTime end;
    static DateTimeFormatter formatFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public static LocalDateTime parseDate(String dateStr) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        return LocalDateTime.parse(dateStr, formatter);
    }

    public Event(String name, String start, String end, long priority) {
        super(name, priority);
        this.start = parseDate(start);
        this.end = parseDate(end);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() +
                "(from: " + start.format(formatFormatter) + " to: "+end.format(formatFormatter) +")";
    }

    @Override
    public String toStorageString() {
        return "[E]" + " " + getDescription() + " " + start + " " + end;
    }
}