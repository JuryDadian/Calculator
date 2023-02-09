package console.util;

import console.Writer;

public final class ConsoleWriter implements Writer {
    public void write(String message) {
        System.out.println(message);
    }

    public void write(char temp) {
        System.out.print(temp);
    }
}
