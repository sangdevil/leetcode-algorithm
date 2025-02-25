package String;

import java.util.Stack;

class Valid_Palindrome {

    public boolean isPalindrome(String s) {
        StringBuilder toLowerCase = new StringBuilder();
        for (char c : s.toCharArray()) {

            if ('A' <= c && c <= 'Z') {
                toLowerCase.append((char) (c - 'A' + 'a'));
            } else if ('a' <= c && c <= 'z' || '0' <= c && c <= '9') {
                toLowerCase.append(c);
            }
        }
        final int length = toLowerCase.length();
        for (int i = 0; i < length / 2; i++) {
            if (toLowerCase.charAt(i) != toLowerCase.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;

    }
}