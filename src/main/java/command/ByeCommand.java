package command;

import storage.Storage;
import task.Roster;
import ui.Ui;

public class ByeCommand extends Command {
    public ByeCommand() {}

    @Override
    public void execute(Roster roster, Ui ui, Storage storage) {
        ui.endMessage();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
