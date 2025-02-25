package Array;

class Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {

        int cp = 1;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxProduct = Math.max(maxProduct, cp * nums[i]);

            if (nums[i] == 0) {
                cp = 1;
            } else {
                cp *= nums[i];
            }
        }
        cp = 1;
        for (int i = nums.length - 1; i >=0; i--) {
            maxProduct = Math.max(maxProduct, cp * nums[i]);
            if (nums[i] == 0) {
                cp = 1;
            } else {
                cp *= nums[i];
            }
        }
        return maxProduct;
    }
}