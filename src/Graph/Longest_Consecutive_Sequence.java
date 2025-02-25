package Graph;

import java.util.HashSet;

public class Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() == 1) {
            return 1;
        }
        int maxLength = 0;
        for (int x : set) {
            if (set.contains(x - 1))
                continue;
            if (!set.contains(x + 1))
                continue;

            int cur = x;
            while (set.contains(cur)) {
                cur++;
            }
            maxLength = Math.max(maxLength, cur - x + 1);
        }
        return maxLength;

    }
}
