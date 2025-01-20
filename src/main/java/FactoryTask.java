public class FactoryTask {

    public static Task newTask(String input) {
        String[] info = input.split(" ", 2);
        String typeName = info[0];
        if (info.length < 2 || info[1].trim().isEmpty()) {
            throw new IllegalArgumentException("Input must include a task type and description.'");
        }
        //TODO: DateTime Formatter
        switch (typeName) {
            case "todo":
                return new ToDo(info[1]);
            case "event":
                if (info.length < 4 ) {
                    throw new IllegalArgumentException("Fix event formatting.'");
                }
                String[] parts = info[1].split("/from|/to");
                String event = parts[0];
                String start = parts[1].trim();
                String end = parts[2].trim();
                return new Event(event, start, end);
            case "deadline":
                if (info.length < 3 ) {
                    throw new IllegalArgumentException("Fix event formatting.'");
                }
                String[] split = info[1].split("/by");
                String deadline = split[1];
                return new Deadline(split[0], deadline);
            default:
                throw new IllegalArgumentException("Unsupported task type: " + typeName);
        }
    }

}
