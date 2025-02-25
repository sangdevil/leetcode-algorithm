package Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Non_Overlapping_Intervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int count = 0;
        int beforeEnd = intervals[0][1];
        int index = 0;
        while (index < intervals.length) {
            if (intervals[index][0] < beforeEnd) {
                count++;
            } else {
                beforeEnd = intervals[index][1];
            }
            index++;
        }
        return count;
    }
}
