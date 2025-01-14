package Statistic.NumericAndStringStatistic;

import Statistic.Statistics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StatisticsForIntAndFloat implements Statistics {

    private boolean option;

    private double min = 10000000;

    private double max = -10000000;
    private  double summ = 0;
    private  long count = 0;


    public StatisticsForIntAndFloat(boolean option){
        this.option = option;
    }

    public double getSumm() {
        return summ;
    }

    public void setSumm(double summ) {
        this.summ = summ;
    }

    public long getCount() {
        return count;
    }

    @Override
    public long getLineCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
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


    @Override
    public void collectStatistic(File file){

        if (file.exists() || getLineCount() != 0) {
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e){
                throw  new RuntimeException(e);
            }

            while (scanner.hasNextLine()){
                float lineValue = Float.parseFloat(scanner.nextLine());
                setSumm(getSumm() + lineValue);
                setCount(getLineCount() + 1);
                if (lineValue > getMax()){
                    setMax(lineValue);
                }
                if (lineValue < getMin()){
                    setMin(lineValue);
                }
            }

            System.out.println("Statistic for" + file.getName());
            System.out.println("Count of elements: "+ getLineCount());
            if (option){
                AdditionalStat();
            }
        }
        else {
            System.out.println("File not exist: " + file.getName());
        }
    }



    public void AdditionalStat(){
        System.out.println("\t└─ Additional details");
        System.out.println("\t\t├──Minimum: " + getMin());
        System.out.println("\t\t├──Maximum: " + getMax());
        System.out.println("\t\t├──Summ: " + summ);
        System.out.println("\t\t└──Average: " + summ/getLineCount());
    }



}
