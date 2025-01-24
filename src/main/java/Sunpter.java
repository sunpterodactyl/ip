import java.util.Scanner;

public class Sunpter {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println(encapsulateInLines(GREETING));
        Scanner scanner = new Scanner(System.in);
        Command commandEnum = Command.EMPTY;
        String input = "";
        while (true) {
            try {
                input = scanner.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new SunpterException("Empty input. Please enter a valid command.");
                }
                String[] inputParts = input.split(" ", 2);
                String commandInput = inputParts[0].toUpperCase();
                try {
                    commandEnum = Command.valueOf(commandInput);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid command. Please enter LIST, TODO, MARK, UNMARK, DEADLINE, EVENT, DELETE, or BYE.");
                    continue;
                }
                if (commandEnum == Command.BYE) {
                    break;
                }
                commandEnum.inputCommand(input);
            } catch (SunpterException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
        System.out.println(encapsulateInLines(FIN));
    }
    public static String encapsulateInLines(String str) {
        String horizontalLine = "____________________________________________________________";
        return horizontalLine + "\n" + str + "\n" + horizontalLine;
    }
    static String GREETING = "Bonjour, je m'appelle Sunpter\n" + "Que puis-je faire pour vous?";
    static String FIN = "Alors, je suis fatigué. Tu parles trop! À bientôt.";
    static String taskDone = "Incroyable! Alors cette tâche est finie.";
    static String taskUnDone = "Alors, cette tâche n'est pas terminée. Essaie plus fort!";
}