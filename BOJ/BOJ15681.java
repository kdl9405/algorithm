package boj;

import java.io.*;
import java.util.*;

/*
 * 트리와 쿼리
 * 
 */
public class BOJ15681 {
    static int N, R, Q;
    static ArrayList<Integer>[] line;
    static boolean[] visit;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        line = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            line[i] = new ArrayList<>();
        }

        dp = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            line[x].add(y);
            line[y].add(x);
        }

        findChildren(R);

        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb.toString());

    }

    static int findChildren(int u) {

        visit[u] = true;

        dp[u] = 1;

        for (int child : line[u]) {
            if (visit[child]) {
                continue;
            }
            dp[u] += findChildren(child);
        }

        return dp[u];
    }
}
