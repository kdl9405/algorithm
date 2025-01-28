package boj;

import java.io.*;

/*
 * 수확
 * 
 * 시간초과
 */

public class BOJ1823_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1]; // 벼

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        max = 0;
        cost = new int[n + 1];

        dfs(1, 1, n);

        System.out.println(max);
    }

    static int[] arr;
    static int[] cost; // 수확 시기때마다 수확한 벼의 가치
    static int max;

    static void dfs(int index, int left, int right) {
        if (left == right) { // 벼가 1개 남은 경우
            int t = 0;
            for (int i = 1; i < cost.length - 1; i++) {
                t += (i * cost[i]);
            }
            t += (index * arr[left]);
            max = Math.max(max, t);
            return;
        }

        // 왼쪽 끝의 벼를 수확하는 경우
        cost[index] = arr[left];
        dfs(index + 1, left + 1, right);

        // 오른쪽 끝의 벼를 수확하는 경우
        cost[index] = arr[right];
        dfs(index + 1, left, right - 1);
    }

}
