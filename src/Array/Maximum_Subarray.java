package Array;

class Maximum_Subarray {
    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int num : nums) {
            if (currentSum > 0 ){
                currentSum += num;
            } else {
                currentSum = num;
            }
            if (currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}