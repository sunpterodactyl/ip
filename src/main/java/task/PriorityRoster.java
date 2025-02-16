package task;

import exception.SunpterException;
import storage.Storage;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Manages task operations
 */
public class PriorityRoster {
    protected ArrayList<Task> rosterList;
    private static Storage STORAGE = new Storage();

    public PriorityRoster(ArrayList<Task> rosterList) {
        this.rosterList = (rosterList == null) ? new ArrayList<>() : rosterList;
    }

    //prepare to remove this
    public PriorityRoster() {
        this.rosterList = new ArrayList<>();
    }

    /**
     * Return the number of tasks in the roster
     * @return int
     */
    public int numberOfTasks() {
        return rosterList.size();
    }

    /**
     * Print the roster task toString
     * @return String
     */
    public String printRoster() {
        if(rosterList.isEmpty()){
            return "Empty Roster";
        }
        else {
            StringBuilder sb = new StringBuilder("Here are the tasks in your roster:\n");
            int taskIndex = 1;
            for (Task task : rosterList) {
                sb.append("\n" + taskIndex + ". " + task.toString());
                taskIndex++;
            }
            return sb.toString();
        }
    }

    /**
     * Add a task to the roster
     * @param task
     */
    public void addTask(Task task) {
        if(task == null){
            throw new SunpterException("This task cannot be empty");
        }
        rosterList.add(task);
        STORAGE.saveTasks(rosterList);
    }
    /**
     * Delete a task from the roster
     */
    public void removeTask(int index) {
        if(index < 1 || index > rosterList.size()){
            throw new IndexOutOfBoundsException("Task index out of bounds");
        }
        Task removedTask = getTask(index);
        rosterList.remove(index - 1);
        STORAGE.saveTasks(rosterList);
    }

    /**
     * Mark a task as completed
     * @param num
     */
    public void markTaskAsCompleted(int num) {
        Task completedTask = getTask(num);
        assert completedTask != null: "This task should not be null";
        completedTask.setCompleted();
        STORAGE.saveTasks(rosterList);
    }

    /**
     * Mark a task as uncompleted
     * @param num
     */
    public void markTaskAsUncompleted(int num) {
        Task uncompletedTask = getTask(num);
        assert uncompletedTask != null: "This task should not be null";
        uncompletedTask.setNotCompleted();
        STORAGE.saveTasks(rosterList);
    }

    /**
     * Retrieves a task based on its index
     * @return a task at index num
     */
    public Task getTask(int num) {
        return rosterList.get(num-1);
    }

    /**
     * Finds all tasks whose descriptions contain the given keyword.
     * If the keyword is not in the tasklist it will return an empty arraylist
     * @param keyword The word to search for in task descriptions.
     * @return A list of tasks that match the keyword.
     */
    public ArrayList<Task> findTaskWithKeyword(String keyword) {
        assert keyword != null;
        return rosterList.stream()
                .filter(task -> task.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public String printPriorityTask() {
        TreeSet<Task> priorityList = getTasksPriorityQueue();
        if(priorityList.isEmpty()){
            return "Empty Roster";
        }
        else {
            StringBuilder sb = new StringBuilder("Here are the ordered tasks in your roster:\n");
            int taskIndex = 1;
            for (Task task : priorityList) {
                sb.append("\n" + taskIndex + ". " + task.toString());
                taskIndex++;
            }
            return sb.toString();
        }
    }

    public TreeSet<Task> getTasksPriorityQueue() {
        TreeSet<Task> priorityList = new TreeSet<>((a,b) -> {
            if (a.getPriority() > b.getPriority()) {
                return Long.compare(a.getPriority(), b.getPriority());
            }
            return Integer.compare(b.getTaskID(), a.getTaskID());
        });

        for(Task task : rosterList){
            priorityList.add(task);
        }
        return priorityList;
    }
}
