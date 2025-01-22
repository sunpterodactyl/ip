public class Task {

    public enum Status{
        FINISHED, UNFINISHED;
    }

    protected String name;
    protected Status status;

    public Task(String name) {
        this.name = name;
        this.status = Status.UNFINISHED;
    }

    public String getStatusIcon() {
        return status == status.FINISHED ? "[X]" : "[ ]";
    }

    public void setCompleted() {
        this.status = status.FINISHED;
    }

    public void setNotCompleted() {
        this.status = status.UNFINISHED;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getStatusIcon() + " " + getName();
    }
}
