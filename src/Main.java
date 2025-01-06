import java.io.File;
import java.util.Scanner;
import java.io.*;

/*
* In - два или более файла с разными типами строк
* Out - 3 файла, в которых отсартированы все строки по типам
*/

public class Main {
    // regular
    static String isInt = "[+-]?\\d+"; // int
    static String isString = "[а-яА-Яa-zA-Z][^.0-9\\r\\n]+.[\\D](?![\\r\\n])"; // string
    static String isFloat = "[+-]?\\d+\\.\\d+([eE][+-]?\\d+)?"; // float

    // main function
    public static void main(String[] args) throws IOException {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("enter file path:");
        String filePath = inputScanner.nextLine();
        System.out.println("enter out file path(Press Enter to save here):");
        String pathOut = inputScanner.nextLine();
        var file = new File(filePath);

        if (pathOut.isEmpty()) {
            pathOut = System.getProperty("user.dir") + File.separator;
        }

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            checkAndWriteLine(scanner.nextLine(), pathOut);
        }

        scanner.close();

    }

    // Check the string and write it to a file
    public static String checkAndWriteLine(String line, String pathOut) throws IOException {

        FileWriter intWriter = new FileWriter(pathOut + "integers.txt", true);
        FileWriter floatWriter = new FileWriter(pathOut + "floats.txt", true);
        FileWriter stringWriter = new FileWriter(pathOut + "strings.txt", true);

        if(line.matches(isInt))
        {
            intWriter.append(line).append("\n");
            intWriter.close();
        }
        if (line.matches(isFloat))
        {
            floatWriter.append(line).append("\n");
            floatWriter.close();;
        }
        if(line.matches(isString))
        {
            stringWriter.append(line).append("\n");
            stringWriter.close();;
        }
        return "";
    }

}