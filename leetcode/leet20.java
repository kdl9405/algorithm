package leetcode;

import java.util.Stack;

public class leet20 {

    public static void main(String[] args) {

        String s = "()[]{}";
        System.out.println(isValid(s));
    }


    public static boolean isValid(String s) {

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (Character c : s.toCharArray()) {
            left.push(c);
        }

        while (!left.isEmpty()) {
            if (!right.isEmpty() && isCorrectPartner(left.peek(), right.peek())) {
                left.pop();
                right.pop();
            } else {
                right.push(left.pop());
            }
        }

        return right.isEmpty();
    }

    private static boolean isCorrectPartner(char c1, char c2) {
        switch (c1) {
            case '(' -> {
                return c2 == ')';
            }
            case '[' -> {
                return c2 == ']';
            }
            case '{' -> {
                return c2 == '}';
            }
        }
        return false;
    }
}
