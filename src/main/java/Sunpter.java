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
        String[] strArr= new String[100];
        int x = 0; //index pointer for strArr

        System.out.println(encapsulateInLines(GREETING));

        while(true) {
            String input = scanner.nextLine();
            if(input.equals("Au revoir")) {
                break;
            }
            else if(input.equals("liste")) {
                StringBuilder sb = new StringBuilder();
                int taskNumber = 1;
                for(String task: strArr) {
                    if(task != null) {
                        sb.append("\n" + taskNumber + ". " + task);
                    }
                    taskNumber++;
                }
                System.out.println(encapsulateInLines(sb.toString()));
            }
            else {
                System.out.println(encapsulateInLines("added: " + input));
                strArr[x] = input;
                x++;
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

}