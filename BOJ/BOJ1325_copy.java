package boj;

/*
 * 효율적인 해킹
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ1325_copy {
    static int N;
    static int M;
    static List<Integer>[] list;
    static int[] visited = new int[10001];
    static int[] ans = new int[10001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N + 1];
        ans = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }
        String[] inputs = new String[2];
        for (int i = 1; i <= M; i++) {
            input = br.readLine();
            inputs = input.split(" ");
            list[Integer.parseInt(inputs[0])].add(Integer.parseInt(inputs[1]));
        }
        for (int i = 1; i <= N; i++) {
            visited = new int[N + 1];

            visited[i] = 1;
            dfs(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, ans[i]);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++) {
            if (max == ans[i])
                sb.append(i + " ");
        }
        System.out.println(sb.toString().trim());

    }

    private static void dfs(int node) {
        for (int next : list[node]) {
            if (visited[next] == 0) {
                ans[next]++;
                visited[next] = 1;
                dfs(next);
            }
        }
    }

}
