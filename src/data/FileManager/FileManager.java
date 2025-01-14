package data.FileManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    private File integers = new File("integers.txt");
    private File floats = new File("floats.txt");
    private File strings = new File("strings.txt");

    public String getIntRegular() {
        return intRegular;
    }

    public String getStringRegular() {
        return stringRegular;
    }

    public String getFloatRegular() {
        return floatRegular;
    }

    public boolean isToggleFileWriterMode() {
        return toggleFileWriterMode;
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

    public FileManager(boolean ToggleFileWriterMode) {
        this.ToggleFileWriterMode = ToggleFileWriterMode;

        try {
            if (!integers.exists()) {
                integers.createNewFile();
            }
            if (!floats.exists()) {
                floats.createNewFile();
            }
            if (!strings.exists()) {
                strings.createNewFile();
            }

            intWriter = new PrintWriter(new FileWriter(integers, this.ToggleFileWriterMode));
            floatWriter = new PrintWriter(new FileWriter(floats, this.ToggleFileWriterMode));
            stringWriter = new PrintWriter(new FileWriter(strings, this.ToggleFileWriterMode));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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

    public void checkFile(){
        if (countInt == 0){
            getIntWriter().close();
            integers.delete();
        }
        if (countFloat == 0){
            getFloatWriter().close();
            floats.delete();
        }
        if (countString == 0){
            getStringWriter().close();
            strings.delete();
        }
    }
}
