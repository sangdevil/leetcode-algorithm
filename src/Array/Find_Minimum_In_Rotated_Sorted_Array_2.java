package Array;

class Find_Minimum_In_Rotated_Sorted_Array_2 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (true) {
            int mid = (l + r) / 2;
            if (nums[l] < nums[r]) {
                r = mid;
            } else if (nums[l] == nums[r]) {
                break;
            } else {
                if (nums[l] < nums[mid]) {
                    l = mid + 1;
                } else if (nums[l] == nums[mid]) {
                    if (nums[l] < nums[r]) {
                        r = l;
                    } else {
                        l = r;
                    }
                } else {
                    r = mid;
                }
            }
            System.out.println(l + " " + r);
        }
        return nums[l];
    }
}
