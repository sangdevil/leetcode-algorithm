package Array;

class Longest_Turbulent_Subarray {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int maxLen = Integer.MIN_VALUE;
        int currentLen = 1;
        int currentSign = -arr[0] + arr[1];
        for (int i = 0; i < arr.length - 1; i++) {
            int nextSign = arr[i] - arr[i+1];
            if (nextSign == 0) {
                currentLen = 1;
            } else {
                if ((currentSign ^ nextSign) < 0) {
                    currentLen++;
                } else {
                    currentLen = 2;
                }
            }
            currentSign = nextSign;
            if (currentLen > maxLen) {
                maxLen = currentLen;
            }
        }
        return maxLen;
    }
}
















