package command;

import storage.Storage;
import task.Roster;
import ui.Ui;

/**
 * List all the tasks in the current roster
 */
public class ListCommand extends Command {

    public ListCommand() {
    }

    @Override
    public void execute(Roster roster, Ui ui, Storage storage) {
        ui.printMessage(roster.printRoster());
    }
}
