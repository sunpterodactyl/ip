package Sunpter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Storage;
import task.Task;
import task.ToDo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class StorageTest {
    private static final String TEST_FILE_PATH = "./data/test_sunpter.txt";
    private Storage storage;

    @BeforeEach
    void setUp() {
        storage = new Storage();
    }

    @AfterEach
    void tearDown() {
        File file = new File(TEST_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testSaveTasks_createsFile() {
        ArrayList<Task> tasks = new ArrayList<>();
        storage.saveTasks(tasks);
        assertTrue(new File("./data/sunpter.txt").exists());
    }

    @Test
    void testSaveTasks_writesCorrectData() throws IOException {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new ToDo("Test Task"));
        storage.saveTasks(tasks);

        Path path = Path.of("./data/sunpter.txt");
        assertTrue(Files.exists(path));

        String content = Files.readString(path).trim();
        assertEquals("Test Task", content);
    }
}