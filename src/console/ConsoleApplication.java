package console;

import console.util.ConsoleReader;
import console.util.ConsoleWriter;
import entity.Operation;
import service.CalculatorService;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;



public class ConsoleApplication implements Application {

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
                    List<Operation> operationsInMemory = calculator.showHistoryInMemory();
                    writer.write("\n HistoryInMemory");
                    operationsInMemory.stream().forEach((o) -> writer.write(o.toString()));

                    try {
                        FileReader fileReader = new FileReader("History.txt");
                        writer.write("\n HistoryInFile");
                        int temp;
                        while ((temp = fileReader.read()) > 0) {
                            writer.write((char) temp);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    List<Operation> operationsInJDBC = calculator.showHistoryInJDBC();
                    writer.write("\n HistoryInJDBC");
                    operationsInJDBC.stream().forEach((operation1 -> writer.write(operation1.toString())));
                    continue;
                case 3:
                    return;
            }
        }
    }
}
