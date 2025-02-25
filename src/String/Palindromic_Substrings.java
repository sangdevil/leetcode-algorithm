package String;

class Palindromic_Substrings {

    public int countSubstrings(String s) {

        char[] chars = s.toCharArray();
        boolean[][] mem = new boolean[chars.length][chars.length];
        int count = chars.length;

        for (int i = 0; i < chars.length; i++) {
            mem[i][i] = true;
        }

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                mem[i][i + 1] = true;
                count++;
            }
        }

        for (int length = 3; length <= chars.length; length++) {
            for (int start = 0; start <= chars.length - length; start++) {
                int end = start + length - 1;

                if (chars[start] == chars[end] && mem[start + 1][end - 1]) {
                    mem[start][end] = true;
                    count++;
                }
            }
        }

        return count;
    }
}