package String;

import java.util.Arrays;

class Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int start = 0;
        int end = 0;
        int count = t.length();
        int[] charCount = new int[256];
        for (char c : t.toCharArray()) {
            charCount[c]++;
        }
        int minLen = Integer.MAX_VALUE;
        int solStart = 0;
        int solEnd = 0;
        while (end < s.length() || count == 0) {
            if (count == 0) {
                if (end - start + 1 < minLen) {
                    solStart = start;
                    solEnd = end;
                    minLen = end - start + 1;
                }
                char c = s.charAt(start);
                charCount[c]++;
                if (charCount[c] > 0) {
                    count++;
                }
                start++;
            } else {
                char c = s.charAt(end);
                charCount[c]--;
                if (charCount[c] >= 0) {
                    count--;
                }
                end++;
            }
        }

        return s.substring(solStart, solEnd);
    }
}