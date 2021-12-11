package BOJ;

import java.io.*;
import java.util.*;

/* 
    PPAP


    가능할 때까지. PPAP를 P로 치환.. 
*/

public class BOJ16120_copy2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] p = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char c : p) {
            if (stack.isEmpty()) {
                stack.add(c);
                continue;
            }

            if (c != 'P') {
                stack.add(c);
                continue;
            }

            if (stack.size() < 3) {
                stack.add(c);
                continue;
            }

            char z = stack.pop();
            char y = stack.pop();
            char x = stack.pop();

            if (x == 'P' && y == 'P' && z == 'A') {
                stack.add(c);
            }else{
                stack.add(x);
                stack.add(y);
                stack.add(z);
                stack.add(c);
            }
        }

        if (stack.size() == 1 && stack.pop() == 'P') {
            System.out.println("PPAP");
        }else{
            System.out.println("NP");
        }
    }
}
