package programmers.month2104;

import java.util.*;

public class so2 {

    public static void main(String[] args) {
        String s = "[](){}";

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;

        for(int i = 0; i<s.length(); i++){
            String test = s.substring(i, s.length())+s.substring(0, i);

            if (check(test)) {
                answer++;
            }
        }

        return answer;
    }

    static boolean check(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char t = s.charAt(i);

            if (t == '{' || t == '[' || t == '(') {
                stack.add(t);
            } else if (!stack.isEmpty()) {
                if (t == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (t == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (t == ')' && stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                return false;
            }

        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;

    }
}
