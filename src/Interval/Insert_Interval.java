package Interval;

import java.util.ArrayList;

public class Insert_Interval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        int maxNum = Math.max(intervals[intervals.length - 1][1], newInterval[1]);
        boolean[] dim1 = new boolean[2 * maxNum + 1];
        for (int[] interval : intervals) {
            dim1[2 * interval[0]] = true;
            dim1[2 * interval[1]] = true;
            for (int i = 2 * interval[0] + 1; i <= 2 * interval[1] - 1; i++) {
                dim1[i] = true;
            }
        }
        dim1[2 * newInterval[0]] = true;
        dim1[2 * newInterval[1]] = true;
        for (int i = 2 * newInterval[0] + 1; i <= 2 * newInterval[1] - 1; i++) {
            dim1[i] = true;
        }

        ArrayList<int[]> list = new ArrayList<>();
        int index = 0;
        while (index <= 2 * maxNum) {
            if (dim1[index]) {
                int start = index;
                while (index <= 2 * maxNum && dim1[index]) {
                    index++;
                }
                list.add(new int[]{start / 2, index / 2});
            } else {
                index++;
            }
            System.out.printf("index : %d\n", index);
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
