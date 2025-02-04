package task;
/*
This class helps keep encapsulate and update a list of tasks
CRUD operations
 */
import storage.Storage;
import java.util.ArrayList;

public class Roster {
    protected ArrayList<Task> rosterList; //just use array for now
    private static Storage STORAGE = new Storage();

    public Roster(ArrayList<Task> rosterList) {
        this.rosterList = rosterList;
    }
    public Roster() {
        this.rosterList = new ArrayList<>();
    }
    //roster length
    public int numberofTasks() {
        return rosterList.size();
    }

    //read from the roster
    public String printRoster() {
        StringBuilder sb = new StringBuilder("Here are the tasks in your roster:\n");
        int taskIndex = 1;
        for (Task task : rosterList) {
            sb.append("\n" + taskIndex + ". " + task.toString());
            taskIndex++;
        }
        return sb.toString();
    }
    //add a task to the roster
    public void addTask(Task task) {
        rosterList.add(task);
        STORAGE.saveTasks(rosterList);
    }
    //delete a task from the roster
    public void removeTask(int index) {
        rosterList.remove(index - 1);
        STORAGE.saveTasks(rosterList);
    }
    //mark a task
    public void markTaskAsCompleted(int num) {
        Task completedTask = getTask(num);
        completedTask.setCompleted();
        STORAGE.saveTasks(rosterList);
    }

    //unmark a task
    public void markTaskAsUncompleted(int num) {
        Task completedTask = getTask(num);
        completedTask.setNotCompleted();
        STORAGE.saveTasks(rosterList);
    }

    //get the task
    public Task getTask(int num) {
        return rosterList.get(num - 1);
    }
    //save a task to a hard disk

}
