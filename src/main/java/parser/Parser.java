package parser;

import command.AddCommand;
import command.MarkCommand;
import command.UnmarkCommand;
import command.ByeCommand;
import command.DeleteCommand;
import command.ListCommand;
import command.Command;
import command.InProgressCommand;
import command.InvalidCommand;
import command.SearchCommand;

import exception.SunpterException;
import ui.Ui;

import java.util.Set;
/**
Handles the parsing and the execution of user commands according to user input
 */
public class Parser {
    private static final Set<String> VALID_COMMANDS =
            Set.of("ADD", "DELETE", "LIST", "MARK", "UNMARK", "BYE", "STARTED","SEARCH");

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
                case "STARTED" -> new InProgressCommand(getNumber(input));
                case "SEARCH" -> new SearchCommand(removeFirstWord(input));
                default -> new InvalidCommand();
            };
        } catch (SunpterException e) {
            return new InvalidCommand();
        }
    }

    /**
    Parses the number of the task for commands such as mark, unmark, and delete.
     Handles the Numberformat exception
     @return valid task number
     */
    private int getNumber(String input) throws NumberFormatException {
        String[] parts = input.split("\\s+"); // Splitting by whitespace
            int number = Integer.parseInt(parts[1]);
            return number;
    }

    /**
     * Removes the first word, specifically for the add command
     */
    public static String removeFirstWord(String str) {
        try {
            int firstSpace = str.indexOf(" ");
            String keyword = str.substring(firstSpace + 1);
            if (keyword.isEmpty()) {
                throw new SunpterException("Invalid command. Please type in {keyword} then {action}");
            }
            return keyword;
        }
        catch (SunpterException e) {
            return Ui.incorrectFormattingError(e.getMessage());
        }
    }
}
