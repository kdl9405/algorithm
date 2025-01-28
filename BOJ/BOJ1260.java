package boj;

import java.io.*;
import java.util.*;

public class BOJ1260 {

    static int[][] connect;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        connect = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            connect[a][b] = 1;
            connect[b][a] = 1;
        }

        dfs(v);
        System.out.println(sb);
        sb = new StringBuilder();
        visit = new boolean[n + 1];

        bfs(v);
        System.out.println(sb);


    }

    static void dfs(int v) {
        visit[v] = true;
        sb.append(v + " ");

        for (int i = 1; i < connect.length; i++) {
            if (!visit[i] && connect[v][i] == 1) {
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visit[v] = true;

        sb.append(v + " ");

        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (int i = 1; i < connect.length; i++) {
                if (connect[n][i] == 1 && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                    sb.append(i + " ");
                }
            }
        }
    }
}
