package command;

import exception.SunpterException;
import storage.Storage;
import task.Roster;
import ui.Ui;

/**
 * Mark a task as done based on its index number
 */
public class MarkCommand extends Command {
    private final int num;

    public MarkCommand(int num) {
        this.num = num;
    }

    @Override
    public String execute(Roster roster, Ui ui, Storage storage) {
        if (num < 1 || num > roster.numberofTasks()) {
            throw new IndexOutOfBoundsException("Please input a valid task number between 1 and "
                                            + (roster.numberofTasks()));
        }
        roster.markTaskAsCompleted(num);
        return ui.markAsCompleted(roster,num);
    }
}
