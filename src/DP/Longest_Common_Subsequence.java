package DP;

import java.util.ArrayList;
import java.util.Arrays;

class Longest_Common_Subsequence {
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int maxLength = 0;
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                int previous = Math.max(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = dp[i-1][j-1] + text1.charAt(i-1) == text2.charAt(j-1) ? 1 : 0;
                dp[i][j] = Math.max(dp[i][j], previous);
                maxLength = Math.max(maxLength, dp[i][j]);
                System.out.println(text1.charAt(i-1) == (text2.charAt(j-1)));

            }
        }
        return maxLength;
    }
}
