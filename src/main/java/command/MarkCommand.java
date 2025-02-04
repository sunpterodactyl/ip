package command;

import storage.Storage;
import task.Roster;
import ui.Ui;

public class MarkCommand extends Command {
    private int num;

    public MarkCommand(int num) {
        this.num = num;
    }

    @Override
    public void execute(Roster roster, Ui ui, Storage storage) {
        roster.markTaskAsCompleted(num);
        ui.markAsCompleted(roster,num);
    }
}
