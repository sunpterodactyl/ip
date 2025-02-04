package command;

import storage.Storage;
import task.Roster;
import ui.Ui;

/**
 * Unmark a task as done based on its index number
 */
public class UnmarkCommand extends Command {
    private int num;

    public UnmarkCommand(int num) {
        this.num = num;
    }

    @Override
    public void execute(Roster roster, Ui ui, Storage storage) {
        roster.markTaskAsUncompleted(num);
        ui.markAsUncompleted(roster,num);
    }
}