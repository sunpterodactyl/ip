package storage;

import task.Task;
// add assertions
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Stores tasks
 */
public class Storage {
    private static final String FILE_PATH = "./data/sunpter.txt";

    public Storage() {}

    /**
     * Saves tasks into a file
     * @param tasks
     */
    public void saveTasks(ArrayList<Task> tasks) {
        try {
            File file = new File(FILE_PATH);
            FileWriter writer = new FileWriter(file);

            for (Task task : tasks) {
                writer.write(task.toStorageString() + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    /**
     * Reads saved tasks from the file sunpter.txt and loads it into the chatbot
     * @return ArrayList<Task>
     */
    public ArrayList<Task> loadTasks() {
        return new ArrayList<>();//STUB
        //TODO
    }
}
