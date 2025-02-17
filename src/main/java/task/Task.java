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
    protected static int taskId = 0;
    protected long priority;

    public Task(String dsc, long p) {
        this.description = dsc;
        this.status = Status.UNFINISHED;
        this.taskId = taskId++;
    }

    /**
     * Returns the priority value a.k.a. the number of points a user earns upon task completion
     * @return the priority value of a task
     */
    public long getPriority() {
        return priority;
    }

    public void setPriority(long p) {
        this.priority = p; //not immutable
    }

    public int getTaskID() {
        return taskId;
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
    }

    public void setNotCompleted() {

        this.status = status.UNFINISHED;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {

        return "[Priority Score: " + getPriority() + "]" + getStatusIcon() + " " + getDescription();
    }

    public String toStorageString() {
        return "";
    }
}
