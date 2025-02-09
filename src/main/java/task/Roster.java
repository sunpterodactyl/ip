package task;
/**
 * A tasklist to manage task operations
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

    /**
     * Return the number of tasks in the roster
     * @return int
     */
    public int numberofTasks() {
        return rosterList.size();
    }

    /**
     * Print the roster task toString
     * @return String
     */
    public String printRoster() {
        StringBuilder sb = new StringBuilder("Here are the tasks in your roster:\n");
        int taskIndex = 1;
        for (Task task : rosterList) {
            sb.append("\n" + taskIndex + ". " + task.toString());
            taskIndex++;
        }
        return sb.toString();
    }

    /**
     * Add a task to the roster
     * @param task
     */
    public void addTask(Task task) {
        rosterList.add(task);
        STORAGE.saveTasks(rosterList);
    }
    /**
     * Delete a task from the roster
     */
    public void removeTask(int index) {
        rosterList.remove(index - 1);
        STORAGE.saveTasks(rosterList);
    }

    /**
     * Mark a task as completed
     * @param num
     */
    public void markTaskAsCompleted(int num) {
        Task completedTask = getTask(num);
        completedTask.setCompleted();
        STORAGE.saveTasks(rosterList);
    }

    /**
     * Mark a task as uncompleted
     * @param num
     */
    public void markTaskAsUncompleted(int num) {
        Task completedTask = getTask(num);
        completedTask.setNotCompleted();
        STORAGE.saveTasks(rosterList);
    }

    /**
     * Retrieves a task based on its index
     * @param num
     * @return a task at index num
     */
    public Task getTask(int num) {
        return rosterList.get(num - 1); //actually this should throw an exception
    }

    /**
     * Finds all tasks whose descriptions contain the given keyword.
     * @param keyword The word to search for in task descriptions.
     * @return A list of tasks that match the keyword.
     */
    public ArrayList<Task> findTaskWithKeyword(String keyword) {
        ArrayList<Task> matchedTasks = new ArrayList<>();
        keyword = keyword.toLowerCase();
        for (Task task : rosterList) {
            if (task.getDescription().toLowerCase().contains(keyword)) {
                matchedTasks.add(task);
            }
        }
        return matchedTasks;
    }

}
