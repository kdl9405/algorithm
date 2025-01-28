package boj;

/*
 * 팰린드롬 만들기
 */

import java.io.*;
import java.util.*;

public class BOJ1213 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();

        Map<Character, Integer> alphabet = new TreeMap<>();
        for (char c : word) {
            alphabet.put(c, alphabet.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        char middle = ' ';

        for (char c : alphabet.keySet()) {

            int cnt = alphabet.get(c);

            while (cnt >= 2) {
                sb.append(c);
                cnt -= 2;
            }

            if (cnt == 1) {
                if (middle == ' ') {
                    middle = c;
                } else {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        if (middle == ' ') {
            answer.append(sb).append(sb.reverse());
        } else {
            answer.append(sb).append(middle).append(sb.reverse());
        }

        System.out.println(answer.toString());

    }
}
