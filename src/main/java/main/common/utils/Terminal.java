package main.common.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Terminal {

    private static Terminal terminal;

    public static Terminal getInstance() {
        if (terminal == null) {
            terminal = new Terminal();
        }
        return terminal;
    }

    private Terminal() {}

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String readString(String title) {
        this.write(title);
        try {
            return reader.readLine();
        } catch (Exception ex) {
            this.writeError("de cadena de caracteres.");
            return this.readString(title);
        }
    }

    public int readInt(String title) {
        try {
            return Integer.parseInt(this.readString(title));
        } catch (Exception ex) {
            this.writeError("entero");
            return this.readInt(title);
        }
    }

    public char readChar(String title) {
        String input = this.readString(title);
        if (input.length() != 1) {
            this.writeError("caracter");
            return this.readChar(title);
        }
        return input.charAt(0);
    }

    public void writeln() {
        System.out.println();
    }

    public void writeln(String title) {
        System.out.println(title);
    }

    public void write(String title) {
        System.out.print(title);
    }

    private void writeError(String format) {
        System.out.print("ERROR E FORMATO! " + "Introduzca un valor con formato " + format + '.');
    }
}

