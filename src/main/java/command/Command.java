package command;

import storage.Storage;
import task.Roster;
import ui.Ui;

public abstract class Command {
    public boolean isExit() {
        return false;
    }
    public abstract void execute(Roster roster, Ui ui, Storage storage);
}
