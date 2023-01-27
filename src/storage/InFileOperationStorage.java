package storage;

import entity.Operation;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InFileOperationStorage implements OperationStorage {
    private static final String FILE = "History.txt";

    public void save (Operation operation){
        try(FileWriter fileWriter = new FileWriter(FILE,true)) {
            fileWriter.write(operation.toString());
            fileWriter.write("\n");
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Operation> findAll() {
        return new ArrayList<>();
    }
}
