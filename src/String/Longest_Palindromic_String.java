package String;

class Longest_Palindromic_String {

    public String longestPalindrome(String s) {
        int solStart = 0;
        int maxLen = 0;

        char[] chars = s.toCharArray();
        boolean[][] mem = new boolean[chars.length][chars.length];

        for (int i = 0; i < chars.length; i++) {
            mem[i][i] = true;
        }

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                mem[i][i + 1] = true;
                solStart = i;
                maxLen = 2;
            }
        }


        for (int length = 3; length <= chars.length; length++) {
            for (int start = 0; start <= chars.length - length; start++) {
                int end = start + length - 1;
                System.out.println(start + " " + end);

                if (chars[start] == chars[end] && mem[start + 1][end - 1]) {
                    mem[start][end] = true;
                    solStart = start;
                    maxLen = length;
                }
            }
        }

        return s.substring(solStart,maxLen);
    }
}