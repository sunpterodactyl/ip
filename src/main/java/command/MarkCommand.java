package command;

import storage.Storage;
import task.Roster;
import ui.Ui;

/**
 * Mark a task as done based on its index number
 */
public class MarkCommand extends Command {
    private final int num;

    public MarkCommand(int num) {
        this.num = num;
    }

    @Override
    public String execute(Roster roster, Ui ui, Storage storage) {
        roster.markTaskAsCompleted(num);
        return ui.markAsCompleted(roster,num);
    }
}
