package command;

import storage.Storage;
import task.Roster;
import ui.Ui;

/**
 * Lists all the tasks in the current roster
 */
public class ListCommand extends Command {

    public ListCommand() {
    }

    @Override
    public String execute(Roster roster, Ui ui, Storage storage) {
        return ui.printMessage(roster.printRoster());
    }
}
