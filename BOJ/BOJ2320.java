package boj;

/*
 * 끝말잇기
 */

import java.io.*;
import java.util.*;

public class BOJ2320 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        dp = new int[5][(1 << N + 1)]; // i부터 시작해야 하는데, j를 사용한 상태에서의 최대 길이.

        alphabet = new HashMap<>();
        alphabet.put('A', 0);
        alphabet.put('E', 1);
        alphabet.put('I', 2);
        alphabet.put('O', 3);
        alphabet.put('U', 4);

        max = 0;

        for (int i = 0; i < 5; i++) {
            max = Math.max(max, sol(i, 0));
        }
        System.out.println(max);
    }

    static int N;
    static String[] words;
    static HashMap<Character, Integer> alphabet;
    static int max;
    static int[][] dp;

    static int sol(int c, int check) {

        if (check == (1 << N) - 1) {
            return 0;
        }

        if (dp[c][check] != 0) {
            return dp[c][check];
        }

        int temp = 0;

        for (int i = 0; i < N; i++) {

            if ((check & (1 << i)) == (1 << i)) {
                continue;
            }

            if (c != alphabet.get(words[i].charAt(0))) {
                continue;
            }

            int n = alphabet.get(words[i].charAt(words[i].length() - 1));

            temp = Math.max(temp, words[i].length() + sol(n, check ^ (1 << i)));

        }

        return dp[c][check] = temp;

    }

}
