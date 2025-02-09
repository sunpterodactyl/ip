package command;

import storage.Storage;
import task.Roster;
import ui.Ui;

/**
 * Unmark a task as in progress based on its index number
 * Uses command started for simpler parsing
 */
public class InProgressCommand extends Command {
    private final int num;

    public InProgressCommand(int num) {
        this.num = num;
    }

    @Override
    public String execute(Roster roster, Ui ui, Storage storage) {
        roster.markTaskAsUncompleted(num);
        return ui.markAsUncompleted(roster,num);
    }
}
