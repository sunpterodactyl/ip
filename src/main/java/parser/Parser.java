package parser;

import command.*;

import exception.SunpterException;

import java.util.Set;
/**
Handles the parsing and the execution of user commands according to user input
 */
public class Parser {
    private static final Set<String> VALID_COMMANDS =
            Set.of("ADD", "DELETE", "LIST", "MARK", "UNMARK", "BYE", "STARTED","SEARCH", "PRIORITY");

    public Command parseCommand(String input) throws SunpterException {
        if(input == null || input.trim().isEmpty()) {
            return new InvalidCommand("PLease type in input. See the help command for more");
        }
        String[] parts = input.trim().split("\\s+", 2);
        String command = parts[0].toUpperCase();

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
                case "PRIORITY" -> new ListPriorityCommand();
                default -> new InvalidCommand("Wrong command. This command does not exist\n" +
                        " Please use the following commands:" + "\n" +
                        "mark , unmark, add, delete, list");
            };
        } catch (SunpterException e) {
            return new InvalidCommand(e.getMessage());
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
     * @throws SunpterException if the input is invalid
     */
    public static String removeFirstWord(String str) throws SunpterException {
        if (str == null || str.trim().isEmpty()) {
            throw new SunpterException("Invalid command. Please type in {keyword} then {action}");
        }

        int firstSpace = str.indexOf(" ");
        if (firstSpace == -1) {
            throw new SunpterException("Invalid command. Please type in {keyword} then {action}");
        }

        String keyword = str.substring(firstSpace + 1).trim();
        if (keyword.isEmpty()) {
            throw new SunpterException("Invalid command. Please type in {keyword} then {action}");
        }

        return keyword;
    }
}
