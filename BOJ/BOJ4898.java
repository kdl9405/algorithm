package boj;

/*
 * 안정적인 문자열
 */

import java.io.*;
import java.util.*;

public class BOJ4898 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index = 1;
        String input = "";

        StringBuilder answer = new StringBuilder();


        while (true) {
            input = br.readLine();

            if (input.startsWith("-")) {
                break;
            }

            answer.append(index).append(". ").append(findCount(input)).append("\n");

            index++;
        }

        System.out.println(answer.toString().trim());
    }

    static int findCount(String S) {

        int count = 0;

        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c == '{') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    stack.add('{');
                    count++;
                } else if (stack.peek() == '{') {
                    stack.pop();
                }
            }
        }

        return count + stack.size() / 2;
    }
}
