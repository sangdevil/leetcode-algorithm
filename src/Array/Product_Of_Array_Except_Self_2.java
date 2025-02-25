package Array;

import java.util.Arrays;

class Product_Of_Array_Except_Self_2 {
    public int[] productExceptSelf(int[] nums) {
        int[] fromStart = new int[nums.length];
        int fromEnd = 1;

        fromStart[0] = nums[0];
        for (int i = 1;i <nums.length;i++) {
            fromStart[i] = fromStart[i - 1] * nums[i];
        }
        for (int i = nums.length - 1; i >=0; i--) {
            if (i == nums.length - 1) {
                fromStart[i] = fromStart[i - 1];
            } else if (i == 0) {
                fromStart[i] = fromEnd;
            } else {
                fromStart[i] = fromEnd * fromStart[i - 1];
            }
            fromEnd *= nums[i];
        }
        return fromStart;
    }
}