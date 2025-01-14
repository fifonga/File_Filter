import Statistic.NumericAndStringStatistic.StatisticsForIntAndFloat;
import Statistic.NumericAndStringStatistic.StatisticsForString;
import Statistic.Statistics;
import data.FileManager.FileManager;

import java.io.File;
import java.util.Scanner;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {

        FileManager fileManager = new FileManager(false);
        Statistics  statInt = new StatisticsForIntAndFloat(true);
        Statistics  statFloat = new StatisticsForIntAndFloat(false);
        Statistics  statString = new StatisticsForString(false);

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("enter file path:");
        File file = new File(inputScanner.nextLine());
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            while (scanner.hasNextLine()) {
                fileManager.doFilter(scanner.nextLine());
            }
            fileManager.checkFile();

            // stats simple or full
            statInt.collectStatistic(fileManager.getIntegers());
            statFloat.collectStatistic(fileManager.getFloats());
            statString.collectStatistic(fileManager.getStrings());
            scanner.close();
        } catch (NullPointerException e) {
            System.out.println("File does not found");
        }
    }
}