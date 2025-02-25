package Binary;

import java.util.Arrays;

class Missing_Number {
    public int missingNumber(int[] nums) {

        int sum = (nums.length) * (nums.length + 1) / 2;
        return sum - Arrays.stream(nums).sum() ;
    }
}