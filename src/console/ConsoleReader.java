package console;

import java.util.Scanner;

public class ConsoleReader implements Reader{

    private Scanner scanner = new Scanner(System.in);

    public String readString() {
        return scanner.next();
    }

    public double readDouble() {
        return scanner.nextDouble();
    }

    public int readInt() {return scanner.nextInt();}

}
