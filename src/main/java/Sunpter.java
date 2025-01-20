import java.util.Scanner;

public class Sunpter {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        //Resources
        Scanner scanner = new Scanner(System.in); //Scanner class for user input, for now
        Roster roster = new Roster();

        System.out.println(encapsulateInLines(GREETING));

        while(true) {
            String input = scanner.nextLine();
            String parts[] = input.split(" ");
            if(parts[0].equals("Bye")) {
                break;
            }
            else if(parts[0].equals("liste")) {
                System.out.println(encapsulateInLines(roster.printRoster()));
            }
            else if(parts[0].equals("mark")) {
                int number = Integer.parseInt(parts[1]);
                roster.markTaskAsCompleted(number);
                System.out.println(encapsulateInLines( taskDone + "\n" + roster.getTask(number).toString()));
            }
            else if(parts[0].equals("unmark")) {
                int number = Integer.parseInt(parts[1]);
                roster.markTaskAsUncompleted(number);
                System.out.println(encapsulateInLines( taskUnDone + "\n" + roster.getTask(number).toString()));
            }
            else {
                //add input
                roster.addTask(new Task(input));
                System.out.println(encapsulateInLines("added: " + input));
            }
        }
        scanner.close();
        System.out.println(encapsulateInLines(EXIT));
    }
    public static String encapsulateInLines (String str){
        String horizontalLine = "____________________________________________________________";
        return horizontalLine + "\n" + str + "\n" + horizontalLine;
    }
    static String GREETING = "Bonjour, je m'apelle Sunpter \n" + "Que puis-je faire pour vous?";
    static String EXIT = "Alors, je suis fatigué. Tu parles trop! À bientôt.";
    //update to french later
    static String taskDone = " Nice! I've marked this task as done:";
    static String taskUnDone = " OK, I've marked this task as not done yet:";

}