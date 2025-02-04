package ui;

import task.Roster;
import task.Task;

import java.util.Scanner;

/**
 * The Ui class handles user interactions by printing formatted messages to the console.
 */
public class Ui {

    private static final String HORIZONTAL_LINE = "____________________________________________________________";
    private static final String GREETING = "Bonjour, je m'appelle Sunpter\nQue puis-je faire pour vous?";
    private static final String FIN = "Alors, je suis fatigué. Tu parles trop! À bientôt.";
    private static final String TASK_DONE = "Incroyable! Alors cette tâche est finie.";
    private static final String TASK_UNDONE = "Alors, cette tâche n'est pas terminée. Essaie plus fort!";
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Reads user commands
     */
    public String readCommand() {
        System.out.print("Enter command: ");
        return scanner.nextLine().trim();
    }
    /**
     * Prints a formatted message with horizontal lines.
     *
     * @param message The message to be printed.
     * @return The formatted message.
     */
    public void printMessage(String message) {
        System.out.println(encapsulateInLines(message));
    }

    /**
     * Prints the welcome message.
     */
    public void showWelcome() {
        System.out.println(encapsulateInLines(GREETING));
    }

    /**
     * Encapsulates a string within horizontal lines for better readability.
     *
     * @param str The string to be encapsulated.
     * @return The formatted string with horizontal lines.
     */
    public static String encapsulateInLines(String str) {
        return HORIZONTAL_LINE + "\n" + str + "\n" + HORIZONTAL_LINE;
    }

    /**
     * Prints a message indicating a task has been removed.
     *
     * @param task   The task to be removed.
     * @param roster The roster from which the task is removed.
     */
    public void removeTaskMessage(Task task, Roster roster) {
        System.out.println(encapsulateInLines(
                "\n" + task.toString() + "\n" +
                "Now you have " + roster.numberofTasks() + " tasks in the list."));
    }

    /**
     * Prints a message indicating a task has been marked as uncompleted.
     *
     * @param roster The roster containing the task.
     * @param number The index of the task.
     */
    public void markAsUncompleted(Roster roster, int number) {
        System.out.println(encapsulateInLines(TASK_UNDONE + "\n" + roster.getTask(number).toString()));
    }

    /**
     * Prints the exit message.
     */
    public void endMessage() {
        System.out.println(encapsulateInLines(FIN));
    }

    /**
     * Prints a message indicating a task has been marked as completed.
     *
     * @param roster The roster containing the task.
     * @param number The index of the task.
     */
    public void markAsCompleted(Roster roster, int number) {
        System.out.println(encapsulateInLines(TASK_DONE + "\n" + roster.getTask(number).toString()));
    }

    /**
     * Prints an error message for incorrect formatting.
     *
     * @param formatting The correct formatting required.
     */
    public void incorrectFormattingError(String formatting) {
        System.out.println(encapsulateInLines("Wrong format! This command should follow " + formatting));
    }

    /**
     * Prints a message when a task does not exist.
     */
    public void taskDoesNotExist() {
        System.out.println(encapsulateInLines("This task doesn't exist!"));
    }

    /**
     * Prints a message indicating a task has been added.
     *
     * @param task       The task that was added.
     * @param rosterSize The current size of the roster.
     */
    public void showTaskAddedMessage(Task task, int rosterSize) {
        String taskAdded = "Got it. I've added this task:" +
                "\n" + task.toString() + "\n" +
                "Now you have " + rosterSize + " tasks in the list.";
        System.out.println(encapsulateInLines(taskAdded));
    }
    /**
     * Shows and explains that the storage is not able to load any tasks
     */
    public void showLoadingError() {
        System.out.println("Error: Unable to load tasks from storage. Starting with an empty task list.");
    }
}
