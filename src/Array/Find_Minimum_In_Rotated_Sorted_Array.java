package Array;

class Find_Minimum_In_Rotated_Sorted_Array {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;


        while (true) {
            int mid = (left + right) / 2;
            if (nums[left] < nums[right]) {
                if (right - left == 1) {
                    left = left + 1;
                } else {
                    left = mid;
                }
            } else if (nums[left] > nums[right]) {
                if (nums[mid] < nums[right]) {
                    right = mid - 1;
                } else if (nums[mid] > nums[right]) {
                    if (right - left == 1) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                }
            } else {
                break;
            }
            System.out.println(String.format("current left : %d, right : %d", left, right));
        }

        if (left == nums.length - 1) {
            return nums[0];
        } else {
            return nums[left + 1];
        }
    }
}
