package FlagManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlagManager {

    private final StringBuilder outputPath = new StringBuilder("");
    private final StringBuilder prefix = new StringBuilder("");

    private boolean ToggleFileWriterMode = false;
    private boolean fullStatistic = false;
    private boolean haveStatistic = false;

    private final List<String> files = new ArrayList<>();

    public List<String> getFiles() {
        return files;
    }

    public String getOutputPath() {
        return outputPath.toString();
    }

    public String getPrefix() {
        return prefix.toString();
    }

    public boolean isToggleFileWriterMode() {
        return ToggleFileWriterMode;
    }

    public boolean isFullStatistic() {
        return fullStatistic;
    }

    public boolean isHaveStatistic() {
        return haveStatistic;
    }

    public void getUserInput(){
        Scanner scanFiles = new Scanner(System.in);
        String files = scanFiles.nextLine();
        String[] options = files.split("\\s+");
        parseUserInput(options);
    }

    public void parseUserInput(String[] options){
        for (int i = 0; i < options.length; i++){
            if ("-o".equals(options[i])) {
                outputPath.append(options[i + 1]);
            } else if ("-p".equals(options[i])) {
                prefix.append(options[i + 1]);
            } else if ("-a".equals(options[i])) {
                ToggleFileWriterMode = true;
            } else if ("-s".equals(options[i])) {
                haveStatistic = true;
                fullStatistic = false;
            } else if ("-f".equals(options[i])) {
                haveStatistic = true;
                fullStatistic = true;
            } else if (options[i].matches(".*[.txt]")) {
                files.add(options[i]);
            }
            else if (options[i-1].equals("-p")  || options[i-1].equals("-o")) {
            }else {
                System.out.println("Unknown option:" + options[i]);
            }
        }
    }
}

