package service;

import entity.Operation;
import storage.InFileOperationStorage;
import storage.InMemoryOperationStorage;
import storage.JDBCOperationStorage;

import java.util.List;



public class CalculatorService {
    private final InFileOperationStorage fileOperationStorage = new InFileOperationStorage();
    private final InMemoryOperationStorage memoryOperationStorage = new InMemoryOperationStorage();
    private final JDBCOperationStorage jdbcOperationStorage = new JDBCOperationStorage();
    public Operation calculate(Operation operation) {

        String stringType = operation.getType().toUpperCase();
        Type type = Type.valueOf(stringType);

        switch (type){
            case SUM:
              operation.setResult(methodSum(operation.getNum1(), operation.getNum2()));
              fileOperationStorage.save(operation);
              memoryOperationStorage.save(operation);
              jdbcOperationStorage.save(operation);
              return operation;
            case SUB:
              operation.setResult(methodSub(operation.getNum1(), operation.getNum2()));
              fileOperationStorage.save(operation);
              memoryOperationStorage.save(operation);
              jdbcOperationStorage.save(operation);
              return operation;
            case MUL:
              operation.setResult(methodMul(operation.getNum1(), operation.getNum2()));
              fileOperationStorage.save(operation);
              memoryOperationStorage.save(operation);
              jdbcOperationStorage.save(operation);
              return operation;
            case DIV:
              operation.setResult(methodDiv(operation.getNum1(), operation.getNum2()));
              fileOperationStorage.save(operation);
              memoryOperationStorage.save(operation);
              jdbcOperationStorage.save(operation);
              return operation;
      }
      return  operation;
    }
    private static double methodSum(double a, double b) {
        return a + b;
    }

    private static double methodSub(double a, double b) {
        return a - b;
    }

    private static double methodMul(double a, double b) {
        return a * b;
    }

    private static double methodDiv(double a, double b) {
        return a / b;
    }

    public List<Operation> showHistoryInMemory() {
            return memoryOperationStorage.findAll();
    }

    public List<Operation> showHistoryInJDBC() {
        return jdbcOperationStorage.findAll();
    }


    private enum Type {
        SUM,
        SUB,
        MUL,
        DIV
    }
}
