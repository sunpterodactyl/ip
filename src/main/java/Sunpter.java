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
            String command = input.split(" ")[0];
            if(command.equals("Bye")) {
                break;
            }
            else if(input.startsWith("liste")) {
                System.out.println(encapsulateInLines(roster.printRoster()));
            }
            else if(input.startsWith("mark")) {
                int number = Integer.parseInt(input.split(" ")[1]);
                roster.markTaskAsCompleted(number);
                System.out.println(encapsulateInLines( taskDone + "\n" + roster.getTask(number).toString()));
            }
            else if(input.startsWith("unmark")) {
                int number = Integer.parseInt(input.split(" ")[1]);
                roster.markTaskAsUncompleted(number);
                System.out.println(encapsulateInLines( taskUnDone + "\n" + roster.getTask(number).toString()));
            }
            else {
                //add input
                Task newTask = FactoryTask.newTask(input);
                roster.addTask(newTask);
                String taskDone = "Got it. I've added this task:\n" +
                                    " " + newTask.toString() +
                                    "\n Now you have " + roster.numberofTasks() + " tasks in the list.";
                System.out.println(encapsulateInLines(taskDone));
            }
        }
        scanner.close();
        System.out.println(encapsulateInLines(EXIT));
    }
    public static String encapsulateInLines (String str){
        String horizontalLine = "____________________________________________________________";
        return horizontalLine + "\n" + str + "\n" + horizontalLine;
    }
    static String GREETING = "Bonjour, je m'apelle Sunpter\n" + "Que puis-je faire pour vous?";
    static String EXIT = "Alors, je suis fatigué. Tu parles trop! À bientôt.";
    //update to french later
    static String taskDone = " Nice! I've marked this task as done:";
    static String taskUnDone = " OK, I've marked this task as not done yet:";

}