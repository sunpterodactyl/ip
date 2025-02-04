package task;

/*
An abstract task class that serves as the base for other types of tasks
Includes basic features for a task: the task description and status(done or not done yet)
 */
public abstract class Task {

    public enum Status{
        FINISHED, UNFINISHED, IN_PROGRESS;
    }

    protected String description;
    protected Status status;

    public Task(String dsc) {
        this.description = dsc;
        this.status = Status.UNFINISHED;
    }

    public String getStatusIcon() {
        return status == status.FINISHED ? "[X]"
                                         : status == status.IN_PROGRESS
                                         ? "[-]"
                                         : "[ ]";
    }

    public void setCompleted() {
        this.status = status.FINISHED;
    }

    public void setInProgress() {
        this.status = status.IN_PROGRESS;
    } //not in use yet

    public void setNotCompleted() {
        this.status = status.UNFINISHED;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return getStatusIcon() + " " + getDescription();
    }
}
