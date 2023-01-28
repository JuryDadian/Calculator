package console;

import entity.Operation;
import service.CalculatorService;

import java.util.List;


public class ConsoleApplication implements Application{

    private final ConsoleReader reader = new ConsoleReader();
    private final ConsoleWriter writer = new ConsoleWriter();
    private final CalculatorService calculator = new CalculatorService();


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
                    writer.write("Введите операцию: sum/sub/mul/div");
                    String type = reader.readString();
                    Operation operation = new Operation(num1, num2, type);
                    Operation result = calculator.calculate(operation);
                    writer.write("Result = " + result.getResult());
                    continue;
                case 2:
                    List<Operation> operations = calculator.showHistory();
                    operations.stream().forEach(
                            (o) -> writer.write(o.toString()));
                    continue;
                case 3:
                    return;
            }
        }
    }
}
