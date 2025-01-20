/*
This class helps keep encapsulate and update a task list.
 */
import java.sql.Array;
import java.util.ArrayList;
public class Roster {
    protected ArrayList<Task> rosterList = new ArrayList<>(); //just use array for now

    Roster() {}

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
    }
    //delete a task from the roster
    public void removeTask(int index) {
        rosterList.remove(index-1);
    }
    //mark a task
    public void markTaskAsCompleted(int num) {
        Task completedTask = getTask(num);
        completedTask.setCompleted();
    }

    //unmark a task
    public void markTaskAsUncompleted(int num) {
        Task completedTask = getTask(num);
        completedTask.setNotCompleted();
    }

    //get the task
    //i will catch any exceptions later ig
    public Task getTask(int num) {
        return rosterList.get(num - 1);
    }
}
