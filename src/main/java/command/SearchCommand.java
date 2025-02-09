package command;

import storage.Storage;
import task.Roster;
import task.Task;
import ui.Ui;

import java.util.ArrayList;

/**
 * Searches for commands containing a keyword
 * Displays a roster of all the commands
 */
public class SearchCommand extends Command {
    String keyword;
    public SearchCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String execute(Roster roster, Ui ui, Storage storage) {
        ArrayList<Task> match = roster.findTaskWithKeyword(keyword);
        Roster searchRoster = new Roster(match);
        return ui.printMessage("Here are the matching tasks in your list:\n" + searchRoster.printRoster());
    }

}
