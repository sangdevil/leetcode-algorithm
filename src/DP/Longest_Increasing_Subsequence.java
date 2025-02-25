package DP;

import java.util.*;

class Longest_Increasing_Subsequence {
    public int binarySearch(ArrayList<Integer> list, int target) {
        if (list.isEmpty()) return -1;
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (list.get(l) > target) {
            return l + 1;
        } else {
            return l;
        }
    }
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> currentLIS = new ArrayList<>();
        int maxLength = Integer.MIN_VALUE;
        currentLIS.add(nums[0]);
        for (int num : nums) {
            int index = binarySearch(currentLIS, num);
            if (index == currentLIS.size()) {
                currentLIS.add(num);
            } else {
                currentLIS.set(binarySearch(currentLIS, num), num);
            }
            System.out.println(currentLIS);
        }
        return currentLIS.size();
    }
}
