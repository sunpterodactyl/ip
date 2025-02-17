package ui;

import task.PriorityRoster;
import task.Task;


/**
 * The Ui class handles user interactions by returning formatted messages to the Sunpter main class.
 */
public class Ui {
    private static final String GREETING = "Bonjour, je m'appelle sunpter.Sunpter\nQue puis-je faire pour vous?";
    private static final String FIN = "Alors, je suis fatigué. Tu parles trop! À bientôt.";
    private static final String TASK_DONE = "Incroyable! Alors cette tâche est finie.";
    private static final String TASK_UNDONE = "Alors, cette tâche n'est pas terminée. Essaie plus fort!";

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
        return TASK_UNDONE + "\n" + roster.getTask(number).toString() +
        "\n" + "Translation: This task isn't completed. Keep trying!";
    }

    /**
     * Prints the exit message.
     */
    public String endMessage() {
        return FIN +  "\n"
        + "Translation: You talk too much anyways - until next time.";
    }

    /**
     * Prints a message indicating a task has been marked as completed.
     *
     * @param roster The roster containing the task.
     * @param number The index of the task.
     */
    public String markAsCompleted(PriorityRoster roster, int number) {
        return TASK_DONE + "\n" + roster.getTask(number).toString()+
        "\n" + "Translation: Great - this task is done!";
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
}