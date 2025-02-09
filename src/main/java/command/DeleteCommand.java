package command;

import storage.Storage;
import task.Roster;
import task.Task;
import ui.Ui;

/**
 * Removes a task from the tasklist by citing its index number
 */
public class DeleteCommand extends Command {
    private int num;

    public DeleteCommand(int num) {
        this.num = num;
    }

    @Override
    public String execute(Roster roster, Ui ui, Storage storage) {
        Task task = roster.getTask(num);
        if (task == null) {
            return ui.taskDoesNotExist();
        }
        roster.removeTask(num);
        return ui.removeTaskMessage(task, roster);
    }
}
