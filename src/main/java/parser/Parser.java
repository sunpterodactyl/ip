package parser;

import command.*;
import exception.SunpterException;
import task.*;
import ui.Ui;
import storage.Storage;

import java.util.Set;
/*
Handles the parsing and the execution of user commands
according to respective commands called
 */
public class Parser {
    private static final Set<String> VALID_COMMANDS = Set.of("ADD", "DELETE", "LIST", "MARK", "UNMARK", "BYE");

    public Command parseCommand(String input) throws SunpterException {
        String[] parts = input.trim().split("\\s+", 2);
        String command = parts[0].toUpperCase();

        if (!VALID_COMMANDS.contains(command)) {
            throw new SunpterException("Incorrect Commmand");
        }
        try {
            return switch (command) {
                case "DELETE" -> new DeleteCommand(getNumber(input));
                case "BYE" -> new ByeCommand();
                case "UNMARK" -> new UnmarkCommand(getNumber(input));
                case "MARK" -> new MarkCommand(getNumber(input));
                case "ADD" -> new AddCommand(removeFirstWord(input));
                case "LIST" -> new ListCommand();
                default -> new InvalidCommand();
            };
        } catch (SunpterException e) {
            return new InvalidCommand();
        }
    }

    /**
    Parse the number of the task for commands such as mark, unmark, and delete.
     Handle the Numberformat and Indexoutofbounds exception
     @param input
     @return valid task number
     */
    private int getNumber(String input) throws NumberFormatException {
        String[] parts = input.split("\\s+"); // Splitting by whitespace
            int number = Integer.parseInt(parts[1]);
            return number;
    }

    /**
     * Removes the first word, specifically for the add command
     * @param str
     * @return str
     */
    public static String removeFirstWord(String str) {
        int firstSpace = str.indexOf(" ");
        return str.substring(firstSpace + 1);
    }
}
