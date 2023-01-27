package service;

import entity.Operation;
import storage.InFileOperationStorage;
import storage.InMemoryOperationStorage;
import storage.OperationStorage;

import java.util.List;


public class CalculatorService {
    private final OperationStorage fileOperationStorage = new InFileOperationStorage();
    private final OperationStorage memoryOperationStorage = new InMemoryOperationStorage();
    public Operation calculate(Operation operation) {

        String stringType = operation.getType().toUpperCase();
        Type type = Type.valueOf(stringType);

        switch (type){
            case SUM:
              operation.setResult(methodSum(operation.getNum1(), operation.getNum2()));
              fileOperationStorage.save(operation);
              memoryOperationStorage.save(operation);
              return operation;
            case SUB:
              operation.setResult(methodSub(operation.getNum1(), operation.getNum2()));
              fileOperationStorage.save(operation);
              memoryOperationStorage.save(operation);
              return operation;
            case MUL:
              operation.setResult(methodMult(operation.getNum1(), operation.getNum2()));
              fileOperationStorage.save(operation);
              memoryOperationStorage.save(operation);
              return operation;
            case DIV:
              operation.setResult(methodDiv(operation.getNum1(), operation.getNum2()));
              fileOperationStorage.save(operation);
              memoryOperationStorage.save(operation);
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

    private static double methodMult(double a, double b) {
        return a * b;
    }

    private static double methodDiv(double a, double b) {
        return a / b;
    }

    public List<Operation> showHistory() {
        return memoryOperationStorage.findAll();
    }

    private enum Type {
        SUM,
        SUB,
        MUL,
        DIV
    }

}
