package boj;

import java.io.*;
import java.util.*;

/*
 * 트리와 쿼리
 * 
 * // List 사용
 */
public class BOJ15681_copy {

    static int N, R, Q;
    static ArrayList<List<Integer>> line;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        line = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            line.add(new ArrayList<>());
        }

        dp = new int[N + 1];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            line.get(x).add(y);
            line.get(y).add(x);

        }

        findChildren(R, 0);

        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb.toString());

    }

    static int findChildren(int u, int parent) {

        if (dp[u] != 0) {
            return dp[u];
        }

        for (int child : line.get(u)) {
            if (child == parent) {
                continue;
            }
            dp[u] += findChildren(child, u);
        }

        dp[u]++;

        return dp[u];
    }
}
