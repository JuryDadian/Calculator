package console.util;

import console.Reader;
import java.util.Scanner;

public final class ConsoleReader implements Reader {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String readString() {
        return SCANNER.next();
    }

    public double readDouble() {
        return SCANNER.nextDouble();
    }

    public int readInt() {return SCANNER.nextInt();}

}
