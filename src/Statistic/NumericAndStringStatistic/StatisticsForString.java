package Statistic.NumericAndStringStatistic;

import Statistic.Statistics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StatisticsForString implements Statistics {

    private  double min = 10000000;
    private  double max = -10000000;
    private long lineCount = 0;
    private boolean option;
    private final boolean haveStatistic;


    public StatisticsForString(boolean option, boolean haveStatistic) {
        this.option = option;
        this.haveStatistic = haveStatistic;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void setLineCount(long lineCount) {
        this.lineCount = lineCount;
    }


    public long getLineCount() {
        return lineCount;
    }

    public long getCount() {
        return lineCount;
    }

    public void setCount(long count) {
        this.lineCount = count;
    }


    public void collectStatistic(File file) {
        if (file.exists() || getLineCount() != 0) {
            Scanner scanner = null;
            try{
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            while (scanner.hasNextLine()) {
                setCount(getCount() + 1);
                String lineValue = String.valueOf(scanner.nextLine());
                if (lineValue.length() > getMax()){
                    setMax(lineValue.length());
                }
                if (lineValue.length() < getMin()){
                    setMin(lineValue.length());
                }
            }

            if (haveStatistic) {
                System.out.println("Statistic for" + file.getName());
                System.out.println("Count of elements: " + getLineCount());
                if (option) {
                    AdditionalStat();
                }
            } else {
                System.out.println("File not exist: " + file.getName());
            }
        }

    }

    public void AdditionalStat(){
        System.out.println("\t└─ Additional details");
        System.out.println("\t\t├──Minimum:\t" + getMin());
        System.out.println("\t\t└──Maximum:\t" + getMax());
    }
}
