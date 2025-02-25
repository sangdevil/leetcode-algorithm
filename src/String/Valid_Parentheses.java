package String;

import java.util.*;

class Valid_Parentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> {
                    stack.push('(');
                }
                case ')' -> {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek() !=  '(') {
                        return false;
                    }
                    stack.pop();
                }
                case '[' -> {
                    stack.push('[');
                }
                case ']' -> {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (!stack.isEmpty() && stack.peek() !=  '[') {
                        return false;
                    }
                    stack.pop();
                }
                case '{' -> {
                    stack.push('{');
                }
                case '}' -> {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (!stack.isEmpty() && stack.peek() !=  '{') {
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}