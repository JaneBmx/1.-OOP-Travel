package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readLine() throws IOException {
        return reader.readLine();
    }
}