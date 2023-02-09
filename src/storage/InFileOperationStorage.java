package storage;

import entity.Operation;
import java.io.*;


public class InFileOperationStorage {
    private static final String FILE = "History.txt";

    public void save(Operation operation) {
        try (FileWriter fileWriter = new FileWriter(FILE, true)) {
            fileWriter.write(operation.toString());
            fileWriter.write("\n");
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



