import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            String[] info = input.split(" ", 2);
            String typeName = info[0];

            if(typeName.equals("todo")){
                System.out.println(info[1]);
            }

            if(typeName.equals("event")){
                String[] parts = info[1].split("/from|/to");
                String event = parts[0];
                String start = parts[1].trim();
                String end = parts[2].trim();
                System.out.println(event + " " + start + " " + end);
            }
            if(typeName.equals("deadline")){
                String[] split = info[1].split("/by");
                String deadline = split[1];
                System.out.println(deadline + " " + split[0]);
            };

            if(typeName.equals("bye")){break;}

        }
    }
}
