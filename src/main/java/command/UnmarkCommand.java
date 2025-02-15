package command;

import exception.SunpterException;
import storage.Storage;
import task.Roster;
import ui.Ui;

/**
 * Unmarks a task as done based on its index number
 */
public class UnmarkCommand extends Command {
    private final int num;

    public UnmarkCommand(int num) {
        this.num = num;
    }

    @Override
    public String execute(Roster roster, Ui ui, Storage storage) {
        if(num < 1 || num > roster.numberofTasks()) {
                throw new IndexOutOfBoundsException("Please input a task number between 1 and " +
                        (roster.numberofTasks()));
        }
        roster.markTaskAsUncompleted(num);
        return ui.markAsUncompleted(roster,num);
    }
}