package boj;

/*
 * 우수 마을
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ1949 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        init();

        findDP(1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));

    }

    private static class town {
        int num;
        town aside;

        town(int num, town aside) {
            this.num = num;
            this.aside = aside;
        }
    }

    static int N;
    static int[] population;
    static town[] towns;
    static boolean[] visit;
    static int[][] dp;

    static void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        population = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        towns = new town[N + 1];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            insert(a, b);
            insert(b, a);
        }

        visit = new boolean[N + 1];
        dp = new int[N + 1][2];
    }

    static void insert(int a, int b) {

        if (towns[a] == null) {
            towns[a] = new town(b, null);
        } else {
            towns[a] = new town(b, towns[a]);
        }

    }

    static void findDP(int n) {

        visit[n] = true;
        dp[n][1] = population[n];

        town s = towns[n];

        while (s != null) {

            if (visit[s.num]) {
                s = s.aside;
                continue;
            }

            findDP(s.num);

            dp[n][0] += Math.max(dp[s.num][0], dp[s.num][1]);
            dp[n][1] += dp[s.num][0];

            s = s.aside;
        }
    }
}
