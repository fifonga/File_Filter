import FlagManager.FlagManager;
import Statistic.NumericAndStringStatistic.StatisticsForIntAndFloat;
import Statistic.NumericAndStringStatistic.StatisticsForString;
import Statistic.Statistics;
import FileManager.FileManager;

import java.io.File;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {

        FlagManager flagManager = new FlagManager();

        flagManager.getUserInput();

        FileManager fileManager = new FileManager(false, flagManager.getOutputPath(), flagManager.getPrefix());
        Statistics statInt = new StatisticsForIntAndFloat(flagManager.isFullStatistic(), flagManager.isHaveStatistic());
        Statistics statFloat = new StatisticsForIntAndFloat(flagManager.isFullStatistic(),flagManager.isHaveStatistic());
        Statistics statString = new StatisticsForString(flagManager.isFullStatistic(), flagManager.isHaveStatistic());

        for (String file : flagManager.getFiles()){
            fileManager.doFilterFile(new File(file));
        }

        fileManager.DeleteEmptyFile();

        statInt.collectStatistic(fileManager.getIntegers());
        statFloat.collectStatistic(fileManager.getFloats());
        statString.collectStatistic(fileManager.getStrings());
    }
}