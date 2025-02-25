package Array;

import java.util.Arrays;

class Product_Of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int curr = 1;
        // 먼저, result[i]에는 0 ~ i - 1까지 곱해진 결과가 담김.
        for (int i = 0; i < nums.length; i++) {
            result[i] *= curr;
            curr *= nums[i];
        }

        curr = 1;
        // 이후에, nums를 반대로 순회하면서 curr을 반대방향 누적곱을 기억하도록 함.
        // result[i]에는 0 ~ i-1의 누적곱이, curr에는 i+1 ~ length - 1까지의 누적곱이 담겨 있으므로,
        // result[i]에 그 둘을 곱한 내용을 저장
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= curr;
            curr *= nums[i];
        }

        return result;
    }
}