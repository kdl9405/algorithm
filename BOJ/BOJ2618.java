package boj;

/*
 * 경찰차
 */

import java.io.*;
import java.util.*;

public class BOJ2618 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        works = new int[W + 1][2];
        for (int i = 1; i <= W; i++) {
            st = new StringTokenizer(br.readLine());
            works[i][0] = Integer.parseInt(st.nextToken());
            works[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[W + 1][W + 1];

        int dist = findDP(0, 0);

        route = new StringBuilder();
        route.append(dist).append("\n");

        getRoute(0, 0);

        System.out.println(route.toString().trim());

    }

    static int N, W;
    static int[][] works;
    static int[][] dp; // i번 사건을 j경찰차가 처리한 경우.
    static int INF = 2000001;
    static StringBuilder route;

    static int findDP(int one, int two) {

        if (one == W || two == W) {
            return 0;
        }

        if (dp[one][two] != 0) {
            return dp[one][two];
        }

        int next = Math.max(one, two) + 1;

        int oneDis = 0;
        int twoDis = 0;

        if (one == 0) {
            oneDis = Math.abs(1 - works[next][0]) + Math.abs(1 - works[next][1]);
        } else {
            oneDis = Math.abs(works[one][0] - works[next][0])
                    + Math.abs(works[one][1] - works[next][1]);
        }

        if (two == 0) {
            twoDis = Math.abs(N - works[next][0]) + Math.abs(N - works[next][1]);
        } else {
            twoDis = Math.abs(works[two][0] - works[next][0])
                    + Math.abs(works[two][1] - works[next][1]);
        }

        return dp[one][two] = Math.min(oneDis + findDP(next, two), twoDis + findDP(one, next));

    }

    static void getRoute(int one, int two) {
        if (one == W || two == W) {
            return;
        }

        int next = Math.max(one, two) + 1;

        int oneDis = 0;
        int twoDis = 0;

        if (one == 0) {
            oneDis = Math.abs(1 - works[next][0]) + Math.abs(1 - works[next][1]);
        } else {
            oneDis = Math.abs(works[one][0] - works[next][0])
                    + Math.abs(works[one][1] - works[next][1]);
        }

        if (two == 0) {
            twoDis = Math.abs(N - works[next][0]) + Math.abs(N - works[next][1]);
        } else {
            twoDis = Math.abs(works[two][0] - works[next][0])
                    + Math.abs(works[two][1] - works[next][1]);
        }

        if (dp[next][two] + oneDis < dp[one][next] + twoDis) {
            route.append("1\n");
            getRoute(next, two);
        } else {
            route.append("2\n");
            getRoute(one, next);
        }
    }

}
