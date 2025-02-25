package Array;

import java.util.EnumSet;

public class Two_Sum2_Input_Array_Is_Sorted {

    public static int binarySearch(int[] numbers, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (numbers[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (numbers[start] == target) {
            return start;
        } else {
            return -1;
        }


    }

    public int[] twoSum(int[] numbers, int target) {


        for (int i = 0; i < numbers.length - 1; i++) {
            int remain = target - numbers[i];
            int find = binarySearch(numbers, remain, i + 1, numbers.length - 1);
            if (find > 0) {
                return new int[]{i + 1, find + 1};
            }

        }

        return new int[]{0, 0};
    }
}
