package Array;

class Search_In_Rotated_Sorted_Array {

    public static int findMaxSortedIndex(int[] nums) {

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
            // System.out.println(String.format("current left : %d, right : %d", left, right));
        }

        return left;
    }

    public static int findTargetInRange(int[] nums, int target, int left, int right) {

        if (left > nums.length - 1) {
            return -1;
        }
//        System.out.println(String.format("input left : %d, right : %d", left, right));
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                if (right - left == 1) {
                    left = mid + 1;
                } else {
                    left = mid;
                }
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
                break;
            }
//            System.out.println(String.format("current left : %d, right : %d", left, right));
        }
        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }

    }

    public int search(int[] nums, int target) {

        // try 1
        int maxSortedIndex = findMaxSortedIndex(nums);
        System.out.println(String.format("max sorted index : %d", maxSortedIndex));
        int findInLeftSorted = findTargetInRange(nums, target, 0, maxSortedIndex);
        if (findInLeftSorted == -1) {
            return findTargetInRange(nums, target, maxSortedIndex + 1, nums.length - 1);
        } else {
            return findInLeftSorted;
        }
    }
}
