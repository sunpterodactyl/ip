public class Task {
    protected String name;
    protected boolean completed;

    public Task(String name) {
        this.name = name;
        this.completed = false;
    }

    public String getStatusIcon() {
        return completed ? "[X]" : "[ ]";
    }

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
