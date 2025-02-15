package command;

import exception.SunpterException;
import storage.Storage;
import task.Roster;
import task.Task;
import ui.Ui;

/**
 * Removes a task from the tasklist by citing its index number
 */
public class DeleteCommand extends Command {
    private final int num;

    public DeleteCommand(int num) {
        this.num = num;
    }

    @Override
    public String execute(Roster roster, Ui ui, Storage storage) {
        if (num < 1 || num > roster.numberofTasks()) {
            throw new IndexOutOfBoundsException("Please input a task number between 1 and " +
                                            (roster.numberofTasks()));
        }
        Task task = roster.getTask(num);
        roster.removeTask(num);
        return ui.removeTaskMessage(task, roster);
    }
}
