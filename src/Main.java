import Statistic.NumericAndStringStatistic.StatisticsForIntAndFloat;
import Statistic.NumericAndStringStatistic.StatisticsForString;
import Statistic.Statistics;
import FileManager.FileManager;

import java.io.File;
import java.util.Scanner;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {

        while (true) {
            FileManager fileManager = new FileManager(false);
            Statistics statInt = new StatisticsForIntAndFloat(true);
            Statistics statFloat = new StatisticsForIntAndFloat(true);
            Statistics statString = new StatisticsForString(true);

            System.out.println("enter file path:");

            Scanner readFiles  = new Scanner(System.in);
            String files = readFiles .nextLine();
            String[] split = files.split("\\s+");
            for (String fileL : split){
                File file = new File(fileL);
                try(Scanner scanner = new Scanner(file)){
                    while (scanner.hasNextLine()) {
                        fileManager.doFilter(scanner.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Make sure you entered the correct file name");
                    System.exit(0);
                }
            }

            fileManager.DeleteEmptyFile();

            statInt.collectStatistic(fileManager.getIntegers());
            statFloat.collectStatistic(fileManager.getFloats());
            statString.collectStatistic(fileManager.getStrings());

        }
    }
}