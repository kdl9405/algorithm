package boj;

import java.io.*;
import java.util.Arrays;

/*
 * 차이를 최대로
 */
public class BOJ10819 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        temp = new int[N];

        visit = new boolean[N];
        dfs(0);

        System.out.println(max);

    }

    static int N;
    static int[] num, temp;
    static int max = 0;
    static boolean[] visit;

    static void dfs(int depth) {

        if (depth == N) {
            int sum = 0;
            for (int i = 1; i < N; i++) {
                sum += (Math.abs(temp[i] - temp[i - 1]));
            }

            max = Math.max(max, sum);

            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            temp[depth] = num[i];
            dfs(depth + 1);
            visit[i] = false;
        }

        return;

    }

}
