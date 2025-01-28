package boj;

/*
 * 모든 순열
 * 
 */

import java.io.*;

public class BOJ10974 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        result = new StringBuilder();
        arr = new int[N];
        visit = new boolean[N + 1];

        dfs(0);

        System.out.println(result.toString());

    }

    static int N;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder result;

    static void dfs(int depth) {

        if (depth == N) {
            for (int a : arr) {
                result.append(a).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            arr[depth] = i;
            dfs(depth + 1);
            visit[i] = false;
        }
    }
}
