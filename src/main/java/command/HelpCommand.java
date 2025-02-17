package command;

import storage.Storage;
import task.PriorityRoster;
import ui.Ui;

public class HelpCommand extends Command {
    String helpMessage = "";//STUB

    public HelpCommand() {}

    @Override
    public String execute(PriorityRoster roster, Ui ui, Storage storage) {
        return helpMessage;
    }
}
