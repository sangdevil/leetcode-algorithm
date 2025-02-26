package Graph;

import java.util.*;

public class Avoid_Flood_In_The_City {


    public static class Pair {
        int lake,index;
        public Pair(int lake, int index) {
            this.lake = lake;
            this.index = index;
        }
    }

    public int[] avoidFlood(int[] rains) {

        HashMap<Integer, Boolean> rainMap = new HashMap<Integer, Boolean>();
        Queue<Pair> pq = new PriorityQueue<Pair>(Comparator.comparingInt(p -> p.index));
        HashMap<Integer, ArrayDeque<Integer>> nextIndexMap = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] != 0) {
                rainMap.put(rains[i], false);
                if (nextIndexMap.containsKey(rains[i])) {
                    nextIndexMap.get(rains[i]).add(i);
                } else {
                    nextIndexMap.put(rains[i], new ArrayDeque<>());
                    nextIndexMap.get(rains[i]).add(i);
                }
            }
        }

        int[] ans = new int[rains.length];
        boolean flood = false;
        for (int i = 0; i < rains.length; i++) {
            int cur = rains[i];
            if (cur == 0) {
                if (pq.isEmpty())  {
                    ans[i] = 1;
                } else {
                    int selectedLake = pq.poll().lake;
                    rainMap.put(selectedLake, false);
                    ans[i] = selectedLake;
                }

            } else {
                if (rainMap.get(cur)) {
                    flood = true;
                    break;
                } else {
                    rainMap.put(cur, true);
                    nextIndexMap.get(cur).poll();
//                    System.out.printf("%d's next index : %d\n", cur, nextIndexMap.get(cur).isEmpty() ? 0 : nextIndexMap.get(cur).peek());
                    pq.add(new Pair(cur, nextIndexMap.get(cur).isEmpty() ? 0 : nextIndexMap.get(cur).peek()));
                    ans[i] = -1;
                }
            }
        }

        return flood ? new int[]{} : ans;
    }
}
