package console;

import entity.Operation;
import service.Calculator;
import storage.InMemoryOperationStorage;


public class ConsoleApplication {

    ConsoleReader reader = new ConsoleReader();
    ConsoleWriter writer = new ConsoleWriter();
    Calculator calculator = new Calculator();
    InMemoryOperationStorage inMemoryOperationStorage = new InMemoryOperationStorage();


    public void run() {
        while (true) {
            writer.write("1 - Calculator, 2 - History, 3 - Exit");
            int i = reader.readInt();

            switch (i) {
                case 1:
                    writer.write("Введите число 1:");
                    double num1 = reader.readDouble();
                    writer.write("Введите число 2:");
                    double num2 = reader.readDouble();
                    writer.write("Введите операцию: sum/sub/mult/div");
                    String type = reader.readString();
                    Operation operation = new Operation(num1, num2, type);
                    Operation result = calculator.calculate(operation);
                    writer.write("Result = " + result.getResult());
                    continue;
                case 2:
                    writer.write(inMemoryOperationStorage.findAll().toString());
                    continue;
                case 3:
                    return;
            }
        }
    }
}
