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

    public StatisticsForString(boolean option) {
        this.option = option;
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

            System.out.println("Statistic for" + file.getName());
            System.out.println("Count of elements: "+ getLineCount());
            if (option) {
                AdditionalStat();
            }
        }

    }

    public void AdditionalStat(){
        System.out.println("\t└─ Additional details");
        System.out.println("\t\t├──Minimum: " + getMin());
        System.out.println("\t\t├──Maximum: " + getMax());
    }
}
