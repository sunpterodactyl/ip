package command;

import storage.Storage;
import task.Roster;
import ui.Ui;

/**
 * Mark a task as in progress based on its index number
 * Uses command "started" for simpler parsing
 */
public class InProgressCommand extends Command {
    private final int num;

    public InProgressCommand(int num) {
        this.num = num;
    }

    @Override
    public String execute(Roster roster, Ui ui, Storage storage) {
        if(num < 1 || num > roster.numberOfTasks()) {
            throw new IndexOutOfBoundsException();
        }
        roster.markTaskAsUncompleted(num);
        return ui.markAsUncompleted(roster,num);
    }
}
