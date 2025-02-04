package task;

/*
A simple subclass of task
Only prints out the task description
 */
public class ToDo extends Task{

    public ToDo(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "[T]" + getStatusIcon() + " " + getDescription();
    }
}
