public class Task {
    protected String name;
    protected boolean completed;
    //I dont think I need an id for now

    public Task(String name) {
        this.name = name;
        this.completed = false;
    }

    public String getStatusIcon() {
        return completed ? "[X]" : "[ ]";
    }

    //oops not in use yet
    public void setCompleted() {
        this.completed = true;
    }

    public void setNotCompleted() {
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getStatusIcon() + " " + getName();
    }
}
