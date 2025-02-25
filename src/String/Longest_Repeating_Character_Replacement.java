package String;

class Longest_Repeating_Character_Replacement {

    public int characterReplacement(String s, int k) {



        int maxCount = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            int left = 0;
            int right = left;
            int count = 0;
            while (right < s.length()) {
                System.out.println(String.format("c, l, r = %c, %d, %d", c, left, right));
                if (s.charAt(right) == c) {
                    right ++;
                } else {
                    if (count < k) {
                        count++;
                        right++;
                    } else if (s.charAt(left) == c) {
                        left++;
                    } else {
                        left++;
                        count--;
                    }
                }
                maxCount = Math.max(maxCount, right - left);
            }


        }


        return maxCount;
    }
}