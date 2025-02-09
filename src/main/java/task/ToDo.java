package task;

/*
Task with a description
 */
public class ToDo extends Task{

    public ToDo(String name) {

        super(name);
    }

    @Override
    public String toString() {

        return "[T]" + getStatusIcon() + " " + getDescription();
    }

    @Override
    public String toStorageString() {
        return "[T]" + " " + getDescription();
    }
}
