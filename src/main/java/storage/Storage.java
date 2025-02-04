package storage;

import task.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {
    private static final String FILE_PATH = "./data/sunpter.txt";

    public Storage() {}

    /**
     * Save tasks into a file
     * @param tasks
     */
    public void saveTasks(ArrayList<Task> tasks) {
        try {
            File file = new File(FILE_PATH);
            FileWriter writer = new FileWriter(file);

            for (Task task : tasks) {
                writer.write(task.toString() + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    /**
     * Read saved tasks from the file sunpter.txt and loads it into the chatbot
     * @return ArrayList<Task>
     */
    public ArrayList<Task> loadTasks() {
        return new ArrayList<>();//STUB
        //TODO
    }
}
