package Interval;

import java.util.ArrayList;

public class Merge_Intervals {

    public int[][] merge(int[][] intervals) {

        if (intervals.length < 2) {
            return intervals;
        }
        int max = Integer.MIN_VALUE;
        for (int[] cur : intervals) {
            if (max < cur[1]) {
                max = cur[1];
            }
        }
        boolean[] coordinate = new boolean[max * 2 + 1];
        ArrayList<int[]> result = new ArrayList<>();
        for (int[] cur : intervals) {
            coordinate[2 * cur[0]] = true;
            coordinate[2 * cur[1]] = true;
            for (int i = 2 * cur[0] + 1 ; i <= 2 * cur[1] - 1; i++) {
                coordinate[i] = true;
            }
        }
        int i = 0;
        while (i < 2 * max + 1) {
            if (coordinate[i]) {
                int start = i / 2;
                while (i < 2 * max + 1 && coordinate[i]) {
                    i++;
                }
                result.add(new int[]{start, i / 2});
            } else {
                i++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
