package Array;

class Container_With_Most_Water {
    public int maxArea(int[] height) {


        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;

        while (i < j) {
            if (height[i] < height[j]) {
                maxArea = Math.max(maxArea, (j - i) * height[i]);
                i++;
            } else {
                maxArea = Math.max(maxArea, (j - i) * height[j]);
                j--;
            }
        }


        return maxArea;

    }
}