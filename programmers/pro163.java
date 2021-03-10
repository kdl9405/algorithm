package programmers;

import java.util.*;

/* 
    괄호 변환

*/
public class pro163 {
    public String solution(String p) {
        String answer = "";

        devide(p);

        answer = sb.toString().trim();

        return answer;
    }

    static StringBuilder sb = new StringBuilder();

    static void devide(String p) {
        int count = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (i != 0 && count == 0) {
                String u = p.substring(0, i + 1);
                String v = "";
                if (i != p.length()) {
                    v = p.substring(i + 1, p.length());
                }

                if (check(u)) {
                    sb.append(u);
                    devide(v);
                } else {
                    sb.append("(");
                    devide(v);
                    sb.append(")");
                    if (u.length() > 2) {
                        sb.append(change(u.substring(1, u.length() - 1)));
                    }
                }

                break;
            }
        }
        return;

    }

    static boolean check(String u) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.add(u.charAt(i));
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    static String change(String u) {

        char[] arr = u.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                arr[i] = ')';
            } else {
                arr[i] = '(';
            }
        }
        u = new String(arr);

        return u;
    }
}
