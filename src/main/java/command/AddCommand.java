package command;
import storage.Storage;
import task.*;
import ui.Ui;

import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Command that takes in input and adds the given task to the taskList
 */
public class AddCommand extends Command {
    private final String input;
    public static final Pattern DEADLINE_FORMAT = Pattern.compile("deadline\\s+(.*?)\\s+/by\\s+(.*)");
    public static final Pattern EVENT_FORMAT = Pattern.compile("event\\s+(.*?)\\s+/from\\s+(.*?)\\s+/to\\s+(.*)");

    public AddCommand(String input) {
        this.input = input;
    }

    @Override
    public String execute(Roster roster, Ui ui, Storage storage) {
        try {
            Task task = createTask(input, ui);
            if (task != null) {
                roster.addTask(task);
                return ui.showTaskAddedMessage(task, roster.numberofTasks());
            }
            return ui.incorrectFormattingError("Task could not be added"); //STUB
        }
        catch (NullPointerException e) {
            return ui.incorrectFormattingError("This task command is incorrect.");
        }
    }

    /**
     * Parses input and creates the task accordingly
     * @param input
     * @return Task object: deadline, event or todo
     */
    private Task createTask(String input, Ui ui) {
        String cmd = input.split(" ")[0];
        try {
            return switch (cmd) {
                case ("deadline") -> {
                    String[] paramDeadline = getDeadline(input, ui, DEADLINE_FORMAT);
                    yield new Deadline(paramDeadline[0], paramDeadline[1]);
                }
                case ("event") -> {
                    String[] eventDeadline = getStartAndEndDate(input, ui, EVENT_FORMAT);
                    yield new Event(eventDeadline[0], eventDeadline[1], eventDeadline[2]);
                }
                case ("todo") -> new ToDo(input.split(" ", 2)[1].trim());
                default -> null;
            };
        } catch (DateTimeParseException e) {
            ui.incorrectFormattingError("Please use the correct date format");
            return null;
        }
    }

    /**
     * Returns a string array with the parsed parameters for a deadline class
     */
    private String[] getDeadline(String input, Ui ui, Pattern pattern) {
        String item="";
        String date="";
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            item = matcher.group(1);
            date = matcher.group(2);
        } else {
            ui.incorrectFormattingError("The deadline format should be: deadline {item} /by {date}");
        }
        return new String[]{item, date} ;
    }

    /**
     * Returns a string array for the creation of an event class
     */
    private String[] getStartAndEndDate (String input, Ui ui, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String nameAndDescription = matcher.group(1);
            String dateStart = matcher.group(2);
            String dateEnd = matcher.group(3);
            return new String[]{nameAndDescription, dateStart, dateEnd};
        } else {
            ui.incorrectFormattingError("evnt formatting: event {item} /from {date} /to{date}");
            return null;
        }
    }
}
