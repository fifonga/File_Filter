package FileManager;

import java.io.*;
import java.util.Scanner;

public class FileManager {
    // regular
    private final String intRegular = "[+-]?\\d+"; // int
    private final String stringRegular = "[а-яА-Яa-zA-Z][^.0-9\\r\\n]+.[\\D](?![\\r\\n])"; // string
    private final String floatRegular = "[+-]?\\d+\\.\\d+([eE][+-]?\\d+)?"; // float

    private boolean ToggleFileWriterMode;

    int countInt = 0;
    int countString = 0;
    int countFloat = 0;

     // rewrite file or don't
     private boolean toggleFileWriterMode;

    private final PrintWriter intWriter;
    private final PrintWriter floatWriter;
    private final PrintWriter stringWriter;


    private String outPath;
    private String prefix;

    public String getIntRegular() {
        return intRegular;
    }

    public String getStringRegular() {
        return stringRegular;
    }

    public String getFloatRegular() {
        return floatRegular;
    }


    public PrintWriter getIntWriter() {
        return intWriter;
    }

    public PrintWriter getFloatWriter() {
        return floatWriter;
    }

    public PrintWriter getStringWriter() {
        return stringWriter;
    }

    public File getIntegers() {
        return integers;
    }

    public File getFloats() {
        return floats;
    }

    public File getStrings() {
        return strings;
    }

    public FileManager(boolean ToggleFileWriterMode, String path, String prefix) {
        this.ToggleFileWriterMode = ToggleFileWriterMode;
        this.outPath = path;
        this.prefix = prefix;

        String separator = String.valueOf(File.separatorChar);

        try {

            String intFile = path + separator + prefix + "integers.txt";
            String floatFile = path + separator + prefix + "floats.txt";
            String strFile = path + separator + prefix + "strings.txt";

            // Файлы для каждого типа строки
            integers = new File(intFile);
            floats = new File(floatFile);
            strings = new File(strFile);

            intWriter = new PrintWriter(new FileWriter(integers, this.ToggleFileWriterMode));
            floatWriter = new PrintWriter(new FileWriter(floats, this.ToggleFileWriterMode));
            stringWriter = new PrintWriter(new FileWriter(strings, this.ToggleFileWriterMode));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String intFile = outPath + prefix + "integers.txt";
    String floatFile = outPath + prefix + "floats.txt";
    String stringFile = outPath + prefix + "strings.txt";

    private File integers = new File(intFile);
    private File floats = new File(floatFile);
    private File strings = new File(stringFile);

    // recording files and collecting statistics
    public void doFilter(String line){
        if (line.matches(getIntRegular())){
            countInt++;
            getIntWriter().append(line).append('\n').flush();
        }
        if (line.matches(getFloatRegular())){
            countFloat++;
            getFloatWriter().append(line).append('\n').flush();
        }
        if (line.matches(getStringRegular())){
            countString++;
            getStringWriter().append(line).append('\n').flush();
        }
    }

    public void doFilterFile(File file) {
        try(Scanner scanner = new Scanner(file)){
            while (scanner.hasNextLine()) {
                doFilter(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found: " + e.getMessage());
            System.exit(1);
        }
    }

    public void DeleteEmptyFile(){
        if (countInt == 0){
            getIntWriter().close();
            if (integers.exists()) {
                integers.delete();
            }
        }
        if (countFloat == 0){
            getFloatWriter().close();
            if (floats.exists()) {
                floats.delete();
            }
        }
        if (countString == 0){
            getStringWriter().close();
            if (strings.exists()) {
                strings.delete();
            }
        }
    }
}
