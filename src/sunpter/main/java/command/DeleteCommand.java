package command;

import exception.SunpterException;
import storage.Storage;
import task.PriorityRoster;
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
    public String execute(PriorityRoster roster, Ui ui, Storage storage) {
        Task task = roster.getTask(num);
        if (task == null) {
            return ui.taskDoesNotExist("");//STUB
        }
        roster.removeTask(num);
        return ui.removeTaskMessage(task, roster);
    }
}
