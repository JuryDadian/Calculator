package service;

import entity.Operation;
import storage.InMemoryOperationStorage;


public class Calculator {

    private final InMemoryOperationStorage storage = new InMemoryOperationStorage();
    public Operation calculate(Operation operation) {
      switch (operation.getType()){
          case "sum":
              operation.setResult(methodSum(operation.getNum1(), operation.getNum2()));
              storage.save(operation);
              return operation;
          case "sub":
              operation.setResult(methodSub(operation.getNum1(), operation.getNum2()));
              storage.save(operation);
              return operation;
          case "mult":
              operation.setResult(methodMult(operation.getNum1(), operation.getNum2()));
              storage.save(operation);
              return operation;
          case "div":
              operation.setResult(methodDiv(operation.getNum1(), operation.getNum2()));
              storage.save(operation);
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

}
