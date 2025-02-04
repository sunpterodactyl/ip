package command;
import storage.Storage;
import task.Roster;
import ui.Ui;

public class InvalidCommand extends Command {
        public InvalidCommand() {}

        @Override
        public void execute(Roster roster, Ui ui, Storage storage) {
            ui.incorrectFormattingError("Wrong command. This command does not exist"
                                            + "\n Please use the following commands:" +
                                             "mark , unmark, add, delete, list");
        }
}
