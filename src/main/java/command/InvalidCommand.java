package command;
import storage.Storage;
import task.Roster;
import ui.Ui;

/**
 * Handles incorrect user command inputs
 */
public class InvalidCommand extends Command {
        public InvalidCommand() {}

        @Override
        public String execute(Roster roster, Ui ui, Storage storage) {
            return ui.incorrectFormattingError("Wrong command. This command does not exist"
                                            + "\n Please use the following commands:" +
                                             "mark , unmark, add, delete, list");
        }
}
