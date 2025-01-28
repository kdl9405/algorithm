
package boj;

/**
 * 
 * 사회망 서비스(SNS)
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ2533 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        init();

        findDP2(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    static int N;
    static Node[] sns;
    static int[][] dp; // i번 친구가 얼리어답터인 경우 = 1 / 아닌 경우 = 0
    static boolean[] visit;

    private static class Node {
        int num;
        Node friend;

        Node(int num, Node friend) {
            this.num = num;
            this.friend = friend;
        }

    }

    static void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sns = new Node[N + 1];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            add(a, b);
            add(b, a);

        }

        dp = new int[N + 1][2];
        visit = new boolean[N + 1];
    }

    static void add(int root, int f) {

        if (sns[root] == null) {
            sns[root] = new Node(f, null);
        } else {
            sns[root] = new Node(f, sns[root]);
        }
    }

    static void findDP(int x) {

        visit[x] = true;
        dp[x][1] = 1;

        for (Node f = sns[x]; f != null; f = f.friend) {

            if (visit[f.num]) {
                continue;
            }


            findDP(f.num);

            dp[x][0] += dp[f.num][1];
            dp[x][1] += Math.min(dp[f.num][0], dp[f.num][1]);

        }

    }

    static void findDP2(int x) {

        visit[x] = true;
        dp[x][1] = 1;

        Node f = sns[x];
        while (f != null) {

            if (visit[f.num]) {
                f = f.friend;
                continue;
            }

            findDP2(f.num);

            dp[x][0] += dp[f.num][1];
            dp[x][1] += Math.min(dp[f.num][0], dp[f.num][1]);

            f = f.friend;
        }

    }

}
