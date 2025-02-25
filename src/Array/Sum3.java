package Array;

import java.util.*;

class Sum3 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                System.out.println(String.format("%d, %d, %d", start,end,sum));
                if (sum == -nums[i]) {
                    res.add(List.of(nums[i], nums[start], nums[end]));
                    while (start < nums.length - 1 && nums[start] == nums[start + 1]) start++;
                    start++;
                } else if (sum < -nums[i]) {
                    start++;
                } else {
                    end--;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
}