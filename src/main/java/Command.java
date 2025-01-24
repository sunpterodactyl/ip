//add support for an unknown command
public enum Command {
    LIST, TODO, MARK, UNMARK, DEADLINE, EVENT, DELETE, BYE, EMPTY;
    public static final Roster roster = new Roster();

    public void inputCommand(String input) {
        String[] inputParts = input.split("\\s+",2);
        System.out.println(inputParts[0]);
        String commandInput = inputParts[0].toUpperCase();
        Command command = Command.valueOf(commandInput);

        switch (command) {
            case DELETE:
                int number = Integer.parseInt(inputParts[1]);
                Task task = roster.getTask(number);
                roster.removeTask(number);
                String removedTask = "Noted. I've removed this task:\n" +
                        "\n" + task.toString() + "\n" +
                        "Now you have " + roster.numberofTasks() + " tasks in the list.";
                System.out.println(Sunpter.encapsulateInLines(removedTask));
                break;
            case BYE:
                break;
            case UNMARK:
                int numberThree = Integer.parseInt(inputParts[1].trim());
                roster.markTaskAsUncompleted(numberThree);
                System.out.println(Sunpter.encapsulateInLines(Sunpter.taskUnDone + "\n" + roster.getTask(numberThree).toString()));
                break;
            case MARK:
                int numberTwo = Integer.parseInt(inputParts[1].trim());
                roster.markTaskAsCompleted(numberTwo);
                System.out.println(Sunpter.encapsulateInLines(Sunpter.taskDone + "\n" + roster.getTask(numberTwo).toString()));
                break;
            case EVENT:
                    String[] eventParts = inputParts[1].split("/from|/to");
                    String event = eventParts[0]; String start = eventParts[1].trim();String end = eventParts[2].trim();
                    Task newEvent = new Event(event, start, end);
                    roster.addTask(newEvent);
                    String eventAdded = "Got it. I've added this task:" +
                            "\n" + newEvent.toString() + "\n" +
                            "Now you have " + roster.numberofTasks() + " tasks in the list.";
                    System.out.println(Sunpter.encapsulateInLines(eventAdded));
                    break;
            case DEADLINE:
                    String[] deadlineParts = inputParts[1].split("/by");
                    String taskName = deadlineParts[0].trim(); String deadline = deadlineParts[1].trim();
                    Task newDeadline = new Deadline(taskName, deadline);
                    roster.addTask(newDeadline);
                    String deadlineAdded = "Got it. I've added this task:" +
                            "\n" + newDeadline.toString() + "\n" +
                            "Now you have " + roster.numberofTasks() + " tasks in the list.";
                    System.out.println(Sunpter.encapsulateInLines(deadlineAdded));
                    break;

            case TODO:
                    if(inputParts[1].isEmpty()) {
                        throw new SunpterException("Empty command");
                    }
                    Task newtodo = new ToDo(inputParts[1].trim());
                    roster.addTask(newtodo);
                    String todoAdded = "Got it. I've added this task:" +
                            "\n" + newtodo.toString() + "\n" +
                            "Now you have " + roster.numberofTasks() + " tasks in the list.";
                    System.out.println(Sunpter.encapsulateInLines(todoAdded));
                    break;
            case LIST:
                System.out.println(Sunpter.encapsulateInLines(roster.printRoster()));
                break;
            default:
        }
    }
}