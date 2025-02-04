package command;

import storage.Storage;
import task.Roster;
import ui.Ui;

public class ListCommand extends Command {

    public ListCommand() {
    }

    @Override
    public void execute(Roster roster, Ui ui, Storage storage) {
        ui.printMessage(roster.printRoster());
    }
}
