package Graph;

import java.util.*;

public class Avoid_Flood_In_The_City2 {



    public int[] avoidFlood(int[] rains) {

        Map<Integer, Integer> lastIndexMap = new HashMap<>();
        TreeSet<Integer> availableZeroes = new TreeSet<>();
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 0);
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                availableZeroes.add(i);
            } else {
                if (lastIndexMap.containsKey(rains[i])) {
                    int lastIndex = lastIndexMap.get(rains[i]);
                    Integer avaiableZeroIndex = availableZeroes.ceiling(lastIndex);
                    if (avaiableZeroIndex == null) {
                        return new int[]{};
                    }
                    ans[avaiableZeroIndex] = rains[i];
                    availableZeroes.remove(avaiableZeroIndex);
                }
                lastIndexMap.put(rains[i], i);
                ans[i] = -1;
            }
        }
        for (int i = 0; i < rains.length; i++) {
            if (ans[i] == 0) {
                ans[i] = 1;
            }
        }

        return ans;
    }
}
