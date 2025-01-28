package boj;

import java.util.*;
import java.io.*;

/*
 * 후위 표기식
 */

public class BOJ1918_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<Character>();

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // 알파벳일 경우
            if (c >= 'A' && c <= 'Z')
                sb.append(c);
            // 연산자일 경우
            // 스택의 top보다 다음 연산자의 우선순위가 클 경우 push
            // 그렇지 않을 경우 pop
            // 괄호가 닫히면 이전 괄호까지 pop
            else {
                switch (c) {
                    case '(':
                        stack.push(c);
                        break;
                    case ')':
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            sb.append(stack.pop());
                        }
                        stack.pop();
                        break;
                    default:
                        while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                            sb.append(stack.pop());
                        }
                        Stack.push(c);
                }
            }
        }

        while (!Stack.isEmpty()) {
            sb.append(Stack.pop());
        }

        System.out.println(sb);
    }

    // 우선 순위
    public static int priority(char ch) {
        if (ch == '(' || ch == ')')
            return 0;
        if (ch == '+' || ch == '-')
            return 1;
        else
            return 2;
    }
}
