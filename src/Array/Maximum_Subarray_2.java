package Array;

class Maximum_Subarray_2 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int current : nums) {
            if (current > 0) {
                if (sum < 0) {
                    sum = current;
                } else {
                    sum += current;
                }
            } else {
                if (sum < 0) {
                    sum = current;
                } else {
                    if (sum + current > 0) {
                        sum += current;
                    } else {
                        sum = current;
                    }
                }
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
















