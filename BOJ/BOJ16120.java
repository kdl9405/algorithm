package BOJ;

import java.io.*;
import java.util.*;

/* 
    PPAP


    가능할 때까지. PPAP를 P로 치환.. 
*/

public class BOJ16120 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] p = br.readLine().toCharArray();

        // Stack<Character> stack = new Stack<>();

        // for (int i = 0; i < p.length; i++) {
        // if (p[i] == 'P') {
        // stack.add('P');
        // } else {

        // if (i<p.length-1 && p[i + 1] == 'P' && stack.size() >= 2) {
        // i++;
        // stack.pop();
        // } else {
        // System.out.println("NP");
        // return;
        // }
        // }
        // }

        int count = 0;

        for (int i = 0; i < p.length; i++) {
            if (p[i] == 'P') {
                count++;
            } else {

                if (i < p.length - 1 && p[i + 1] == 'P' && count >= 2) {
                    i++;
                    count--;
                } else {
                    System.out.println("NP");
                    return;
                }
            }
        }

        System.out.println(count == 1 ? "PPAP" : "NP");

    }
}
