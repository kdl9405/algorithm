package BOJ;

/* 
    좋은 단어
*/

import java.io.*;
import java.util.*;

public class BOJ3986 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ3986().solution();
    }

    void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        while (N-- > 0) {
            if (isPositive(br.readLine().toCharArray())) {
                count++;
            }
        }

        System.out.println(count);
    }

    boolean isPositive(char[] word) {

        if (word.length %2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length; i++) {
            if (stack.isEmpty()) {
                stack.push(word[i]);
            } else {
                if (stack.peek() == word[i]) {
                    stack.pop();
                } else {
                    stack.push(word[i]);
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
