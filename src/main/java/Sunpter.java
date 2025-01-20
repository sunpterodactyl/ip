public class Sunpter {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        String horizontalLine = "____________________________________________________________";
        String greeting = "Hello, I'm Sunpter \n" + "What can I do for you?";
        String exit = "Goodbye! Until next time.";

        System.out.println("Hello from\n" + logo);
        System.out.println(horizontalLine);
        System.out.println(greeting + "\n" + horizontalLine);
        System.out.println(exit + "\n" + horizontalLine);
    }
}
