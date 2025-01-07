import java.io.File;
import java.util.Scanner;
import java.io.*;

public class Main {
    // regular
    static String isInt = "[+-]?\\d+"; // int
    static String isString = "[а-яА-Яa-zA-Z][^.0-9\\r\\n]+.[\\D](?![\\r\\n])"; // string
    static String isFloat = "[+-]?\\d+\\.\\d+([eE][+-]?\\d+)?"; // float

    // writes
    static PrintWriter intWriter;
    static PrintWriter floatWriter;
    static PrintWriter stringWriter;

    // file name
    static File integers = new File("integers.txt");
    static File floats = new File("floats.txt");
    static File strings = new File("strings.txt");

    // main function
    public static void main(String[] args) throws IOException {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("enter file path:");
        File file = new File(inputScanner.nextLine());

        toggleFileWriterMode(false);

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            checkAndWriteLine(scanner.nextLine());
        }

        scanner.close();
    }

    // Check the string and write it to a file
    public static void checkAndWriteLine(String line) {

        if (line.matches(isInt)) {
            intWriter.append(line).append("\n");
            intWriter.flush();
        }
        if (line.matches(isFloat)) {
            floatWriter.append(line).append("\n");
            floatWriter.flush();
        }
        if (line.matches(isString)) {
            stringWriter.append(line).append("\n");
            stringWriter.flush();
        }

    }

    // true - add, false - new file
    public static void toggleFileWriterMode(boolean appendMode) {
        try {
            intWriter = new PrintWriter(new FileWriter(integers, appendMode));
            floatWriter = new PrintWriter(new FileWriter(floats, appendMode));
            stringWriter = new PrintWriter(new FileWriter(strings, appendMode));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}