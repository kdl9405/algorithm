package programmers.month2104;

import java.util.*;

public class so2_copy {

    public static void main(String[] args) {
        String s = "[](){}";

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;

        Queue<Character> queue = new LinkedList<>();

        for(int i = 0; i<s.length(); i++){
            queue.add(s.charAt(i));
        }

        System.out.println(new String(queue.toString()));

        

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
