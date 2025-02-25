package Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals_2 {

    public int[][] merge(int[][] intervals) {

        if (intervals.length < 2) {
            return intervals;
        }
        int i = 0;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);
        while (i < intervals.length) {
            if ( i < intervals.length - 1 && intervals[i+1][0] <= intervals[i][1])  {
                int start = intervals[i][0];
                int end = Integer.MIN_VALUE;
                while (i < intervals.length - 1 && intervals[i+1][0] <= intervals[i][1]) {
                    end = Math.max(end, intervals[i][1]);
                    i++;
                }
                list.add(new int[]{start, end});
            } else {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }
}
