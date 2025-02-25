package String;

import java.util.Arrays;
import java.util.HashSet;

class Longest_Substring_Without_Repeating_Characters_2 {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int index = 0;
        int maxLen = 0;
        int[] charBefore = new int[256];
        Arrays.fill(charBefore, -1);
        for (char c : s.toCharArray()) {
            if (index - charBefore[c] > length) {
                length++;
            } else {
                length = index - charBefore[c];
            }
            charBefore[c] = index;
            index++;
            maxLen = Math.max(maxLen, length);
        }
        return maxLen;
    }
}