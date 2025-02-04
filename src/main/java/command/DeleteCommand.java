package command;

import storage.Storage;
import task.Roster;
import task.Task;
import ui.Ui;

public class DeleteCommand extends Command {
    private int num;

    public DeleteCommand(int num) {
        this.num = num;
    }

    @Override
    public void execute(Roster roster, Ui ui, Storage storage) {
        Task task = roster.getTask(num);
        if (task == null) {
            ui.taskDoesNotExist();
            return;
        }
        ui.removeTaskMessage(task, roster);
        roster.removeTask(num);
    }
}
