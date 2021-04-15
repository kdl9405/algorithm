package programmers.month2104;

import java.util.*;

// 

public class so3_copy {

    public static void main(String[] args) {

        int[] a = { -5, 5 };
        int[][] edges = { { 0, 1 } };

        System.out.println(solution(a, edges));
    }

    static HashMap<Integer, HashSet<Integer>> line;
    static long[] dp;
    static boolean[] visit;
    static long answer;

    public long solution(int[] a, int[][] edges) {
        answer = 0;
        line = new HashMap<>();
        dp = new long[a.length];
        visit = new boolean[a.length];
        for (int[] edge : edges) {
            if (!line.containsKey(edge[0])) {
                line.put(edge[0], new HashSet<>());
            }
            if (!line.containsKey(edge[1])) {
                line.put(edge[1], new HashSet<>());
            }

            line.get(edge[0]).add(edge[1]);
            line.get(edge[1]).add(edge[0]);
        }

        answer = findDP(0, a);

        if (a[0] != 0) {
            return -1;
        }

        return answer;
    }

    static long findDP(int n, int[] a) {
        // dp : n까지의 이동횟수

        visit[n] = true;

        long temp = 0;

        for (int e : line.get(n)) {
            if (visit[e]) {
                continue;
            }

            temp += findDP(e, a) + Math.abs(a[e]);

            a[n] += a[e];
        }

        return dp[n] = temp;
    }
}