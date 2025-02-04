import command.Command;
import exception.SunpterException;
import parser.Parser;
import storage.Storage;
import task.Roster;
import ui.Ui;

import java.util.Scanner;

public class Sunpter {
    private Storage storage;
    private Roster roster;
    private Ui ui;
    private Parser parser;

    public Sunpter() {
        ui = new Ui();
        storage = new Storage();
        try {
            roster = new Roster(storage.loadTasks());
        } catch (SunpterException e) {
            ui.showLoadingError();
            roster = new Roster();
        }
        parser = new Parser();
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = parser.parseCommand(fullCommand);
                c.execute(roster, ui, storage);
                isExit = c.isExit();
            } catch (SunpterException e) {
                ui.printMessage("Error try again please");
            }
        }
    }

    public static void main(String[] args) {
        new Sunpter().run();
    }
}