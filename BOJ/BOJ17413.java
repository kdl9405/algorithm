package boj;

import java.io.*;
import java.util.Stack;

/*
 * 단어 뒤집기 2
 */

public class BOJ17413 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append('<');

                for (int j = i + 1; j < s.length(); j++) {
                    sb.append(s.charAt(j));

                    if (s.charAt(j) == '>') {
                        i = j;
                        break;
                    }
                }
            } else if (s.charAt(i) == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            } else {
                stack.add(s.charAt(i));
            }

        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString().trim());
    }

}
