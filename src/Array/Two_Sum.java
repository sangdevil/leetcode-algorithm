package Array;

import java.util.*;
class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (numMap.containsKey(remain)) {
                return new int[]{numMap.get(remain), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[] {0, 0};
    }
}