package Statistic;

import java.io.File;

public interface Statistics {
    long getLineCount();

    void collectStatistic(File file, boolean option);
}
