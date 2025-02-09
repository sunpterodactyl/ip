package command;

import storage.Storage;
import task.Roster;
import ui.Ui;

/**
 * Base command class with an execute function
 */
public abstract class Command {
    public boolean isExit() {
        return false;
    }
    public abstract String execute(Roster roster, Ui ui, Storage storage);
}
