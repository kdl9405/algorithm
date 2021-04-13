package BOJ;

import java.util.*;

/* 
    후위 표기식
*/

public class BOJ1918 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

 

        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(c);
            } else {
                switch (c) {
                    case '(':
                        stack.push(c);
                        break;

                    case ')':
                        while (!stack.isEmpty() && stack.peek()!='(') {
                            sb.append(stack.pop());
                        }
                        stack.pop();
                        break;

                    default:
                        while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                        break;
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    static int priority(char c) {
        if (c == '(' || c == ')') {
            return 0;
        }
      

        if (c == '+' || c == '-') {
            return 2;
        }
        return 3;
    }

}
