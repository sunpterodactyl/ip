package command;
import exception.SunpterException;
import storage.Storage;
import task.*; //FIX
import ui.Ui;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import task.PriorityRoster;

/**
 * Command that takes in input and adds the given task to the taskList
 */
public class AddCommand extends Command {
    private final String input;
    public static final Pattern DEADLINE_FORMAT = Pattern.compile(
            "deadline\\s+(.*?)\\s+/by\\s+(.*?)\\s+/priority\\s+(\\d+)");
    public static final Pattern EVENT_FORMAT = Pattern.compile(
            "event\\s+(.*?)\\s+/from\\s+(.*?)\\s+/to\\s+(.*?)\\s+/priority\\s+(\\d+)");
    public static final Pattern TODO_FORMAT = Pattern.compile(
            "todo\\s+(.*?)\\s+/priority\\s+(\\d+)");

    public AddCommand(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        this.input = input.trim();
    }

    @Override
    public String execute(PriorityRoster roster, Ui ui, Storage storage) {
        try {
            Task task = createTask(input);
            roster.addTask(task);
            return ui.showTaskAddedMessage(task, roster.numberOfTasks());
        } catch (SunpterException e) {
            return e.getMessage();
        }
    }

    /**
     * Parses input and creates the task accordingly
     * @param input user input string
     * @return Task object: deadline, event or todo
     * @throws SunpterException if the input format is invalid
     */
    private Task createTask(String input) throws SunpterException {
        String[] parts = input.split("\\s+", 2);
        if(parts.length < 2) {
            throw new SunpterException("Invalid task format");
        }
        String cmd = parts[0];

        try {
            return switch (cmd) {
                case ("deadline") -> {
                    String paramDeadline = getDeadlineEndDate(input);
                    String item = getItem(input, DEADLINE_FORMAT);
                    int priority = getPriority(input, DEADLINE_FORMAT);
                    yield new Deadline(item, paramDeadline, priority);
                }
                case ("event") -> {
                    String item = getItem(input, EVENT_FORMAT);
                    String[] eventDeadline = getEventDates(input);
                    int priority = getPriority(input, EVENT_FORMAT);
                    yield new Event(item, eventDeadline[0], eventDeadline[1], priority);
                }
                case ("todo") -> {
                    String item = getItem(input, TODO_FORMAT);
                    int priority = getPriority(input, TODO_FORMAT);
                    yield new ToDo(item, priority);
                }
                default -> throw new SunpterException("Task command should be add {todo/deadline/event}");
            };
        } catch (DateTimeParseException e) {
            throw new SunpterException("Invalid date format: " + e.getMessage());
        }
    }

    /**
     * Parses the deadline from the deadline task
     *
     * @param input user input string
     * @return extracted deadline date
     * @throws SunpterException if the format is invalid
     */
    private String getDeadlineEndDate(String input) throws SunpterException {
        Matcher matcher = AddCommand.DEADLINE_FORMAT.matcher(input);
        if (matcher.find()) {
            String deadline = matcher.group(2).trim();
            if (deadline.isEmpty()) {
                throw new SunpterException("Deadline cannot be empty");
            }
            return deadline;
        }
        throw new SunpterException("Invalid deadline format. Expected: deadline {item} /by {date} /priority {number}");
    }

    /**
     * Parses the start and end dates for an event task
     *
     * @param input user input string
     * @return array containing start and end dates
     * @throws SunpterException if the format is invalid
     */
    private String[] getEventDates(String input) throws SunpterException {
        Matcher matcher = AddCommand.EVENT_FORMAT.matcher(input);
        if (matcher.find()) {
            String start = matcher.group(2).trim();
            String end = matcher.group(3).trim();
            if (start.isEmpty() || end.isEmpty()) {
                throw new SunpterException("Event dates cannot be empty");
            }
            return new String[]{start, end};
        }
        throw new SunpterException("Invalid event format. Expected: event {item} /from {date} /to {date} /priority {number}");
    }

    /**
     * Parses a task description
     * @param input user input string
     * @param pattern regex pattern to match
     * @return extracted task description
     * @throws SunpterException if the format is invalid
     */
    private String getItem(String input, Pattern pattern) throws SunpterException {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String item = matcher.group(1).trim();
            if (item.isEmpty()) {
                throw new SunpterException("Task description cannot be empty");
            }
            return item;
        }
        throw new SunpterException("Invalid format. Unable to extract item description.");
    }

    /**
     * Parses the priority level for a task object
     * @param input user input string
     * @param pattern regex pattern to match
     * @return extracted priority level
     * @throws SunpterException if the format is invalid
     */
    private int getPriority(String input, Pattern pattern) throws SunpterException {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String priorityGroup = pattern.pattern().contains("todo") ? matcher.group(2) : matcher.group(4);
            try {
                return Integer.parseInt(priorityGroup.trim());
            } catch (NumberFormatException e) {
                throw new SunpterException("Priority must be a valid number");
            }
        }
        throw new SunpterException("Invalid format. Unable to extract priority.");
    }
}