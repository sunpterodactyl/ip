public class Task {
    private String name;
    private boolean completed;
    //I dont think I need an id for now

    public Task(String name) {
        this.name = name;
        this.completed = false;
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
}
