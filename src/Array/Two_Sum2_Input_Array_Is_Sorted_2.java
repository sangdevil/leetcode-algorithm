package Array;

public class Two_Sum2_Input_Array_Is_Sorted_2 {

    public int[] twoSum(int[] numbers, int target) {

        int start = 0, end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];

            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[]{0, 0};
    }
}
