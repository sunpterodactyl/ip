package storage;

import exception.SunpterException;
import task.Task;

import java.io.*;
import java.util.ArrayList;
import parser.StorageParser;

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
        }
        catch (IOException e) {
            throw new SunpterException("Error saving tasks to file");
        }
    }

    /**
     * Reads saved tasks from the file sunpter.txt and loads it into the chatbot
     * @return ArrayList<Task>
     */
    public ArrayList<Task> loadTasks() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File not found, returning empty task list.");
            return new ArrayList<>();
        }
        ArrayList<Task> taskValues = read(file);
        return taskValues;
    }

    public ArrayList<Task> read(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        ArrayList<Task> tasks = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.trim().isEmpty()) {  // Avoid adding empty lines
                tasks.add(StorageParser.parseStoredTask(line));
            }
        }
        return tasks;
    }
}
