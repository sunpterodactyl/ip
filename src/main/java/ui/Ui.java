package ui;

import task.PriorityRoster;
import task.Task;


/**
 * The Ui class handles user interactions by returning formatted messages to the Sunpter main class.
 */
public class Ui {
    private static final String GREETING = "Hi, I'm Sunpter I help you prioritise. Type help to get my user guide.";
    private static final String FIN = "Ok bye.";
    private static final String TASK_DONE = "Incredible! This task is completed!";
    private static final String TASK_UNDONE = "Unmarked. Keep trying!";

    public Ui() {
    }

    /**
     * Prints a formatted message with horizontal lines.
     *
     * @param message The message to be printed.
     * @return The formatted message.
     */
    public String printMessage(String message) {
        return message;
    }

    /**
     * Prints the welcome message.
     */
    public static String showWelcome() {
        return GREETING + "\n" +
        "Translation: Hi my name is Sunpter, how can I help?";
    }

    /**
     * Returns a message indicating a task has been removed.
     *
     * @param task   The task to be removed.
     * @param roster The roster from which the task is removed.
     */
    public String removeTaskMessage(Task task, PriorityRoster roster) {
        return "removed" +
                "\n" + task.toString() + "\n" +
                "Now you have " + roster.numberOfTasks() + " tasks in the list.";
    }

    /**
     * Returns a message indicating a task has been marked as uncompleted.
     *
     * @param roster The roster containing the task.
     * @param number The index of the task.
     */
    public String markAsUncompleted(PriorityRoster roster, int number) {
        return TASK_UNDONE + "\n" + roster.getTask(number).toString();
    }

    /**
     * Prints the exit message.
     */
    public String endMessage() {
        return FIN;
    }

    /**
     * Prints a message indicating a task has been marked as completed.
     *
     * @param roster The roster containing the task.
     * @param number The index of the task.
     */
    public String markAsCompleted(PriorityRoster roster, int number) {
        return TASK_DONE + "\n" + roster.getTask(number).toString();
    }

    /**
     * Prints an error message for incorrect formatting.
     *
     * @param formatting The correct formatting required.
     */
    public static String incorrectFormattingError(String formatting) {
        return"Wrong format! This command should follow " + formatting;
    }

    /**
     * Prints a message when a task does not exist.
     */
    public String taskDoesNotExist(String message) {
        return "This task doesn't exist!" + "\n" + message;
    }

    /**
     * Prints a message indicating a task has been added.
     *
     * @param task       The task that was added.
     * @param rosterSize The current size of the roster.
     */
    public String showTaskAddedMessage(Task task, int rosterSize) {
        String taskAdded = "Got it. I've added this task:" +
                "\n" + task.toString() + "\n" +
                "Now you have " + rosterSize + " tasks in the list.";
        return taskAdded;
    }

    /**
     * Shows and explains that the storage is not able to load any tasks
     */
    public String showLoadingError() {
        return "Error: Unable to load tasks from storage. Starting with an empty task list.";
    }
    /**
     * Shows the number of priority points earned by completed tasks
     */
    public String priorityPoints(PriorityRoster roster) {
        int completedPoints = roster.getCompletedPriorityPoints();
        int totalPoints = roster.getTotalPriorityPoints();
        int percentage = (int) Math.round(((double) completedPoints / totalPoints) * 100);
        return " You’ve completed " +
                 completedPoints+ "/" + totalPoints +
                "priority points " + percentage +". Keep going! 🚀";
    }
}