public class FactoryTask {
    //TODO: Add in illegal argument exception
    //TODO: Ensure the String has length > 1
    public static Task newTask(String input) {
        String[] info = input.split(" ", 2);
        String typeName = info[0];
        //TODO: DateTime Formatter
        switch (typeName) {
            case "todo":
                return new ToDo(info[1]);
            case "event":
                String[] parts = info[1].split("/from|/to");
                String event = parts[0];
                String start = parts[1].trim();
                String end = parts[2].trim();
                return new Event(event, start, end);
            case "deadline":
                String[] split = info[1].split("/by");
                String deadline = split[1];
                return new Deadline(split[0], deadline);
            default:
                throw new IllegalArgumentException("Unsupported task type: " + typeName);
        }
    }

}
