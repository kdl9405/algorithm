package boj;

import java.io.*;
import java.util.*;

/*
 * 작업
 * 
 * 892 ms
 */

public class BOJ2056_copy {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1]; // 1번 작업을 완료한 최소시간
        before = new HashMap<>();
        times = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            int bCount = Integer.parseInt(st.nextToken());

            times.put(i, time);

            if (bCount > 0) {
                List<Integer> bList = new ArrayList<>();
                while (bCount-- > 0) {
                    bList.add(Integer.parseInt(st.nextToken()));
                }
                before.put(i, bList);
            } else {
                dp[i] = time;
            }
        }

        total = 0;
        for (int i = 1; i <= n; i++) {
            total = Math.max(total, findDP(i));
        }
        System.out.println(total);
    }

    static int[] dp;
    static HashMap<Integer, List<Integer>> before;
    static HashMap<Integer, Integer> times;
    static int total;

    static int findDP(int n) {

        if (dp[n] != 0) {
            return dp[n];
        }

        for (Integer b : before.get(n)) {
            dp[n] = Math.max(dp[n], findDP(b) + times.get(n));
        }

        return dp[n];
    }
}
