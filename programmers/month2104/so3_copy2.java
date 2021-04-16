package programmers.month2104;

import java.util.*;

//  런타임 에러 3개

public class so3_copy2 {

    public static void main(String[] args) {
                
        int[] a = { -5, 0, 2, 1, 2 };
        int[][] edges = { { 0, 1 }, { 3, 4 }, { 2, 3 }, { 0, 3 } };

        System.out.println(solution(a, edges));
    }

    static ArrayList<ArrayList<Integer>> line;
    static long[] dp;
    static boolean[] visit;
    static long answer;
    static long[] w;

    public static long solution(int[] a, int[][] edges) {

        long sum = 0;
        for (int x : a) {
            sum += x;
        }

        if (sum != 0) {
            return -1;
        }

        if (a.length == 2) {
            if (a[0] + a[1] == 0) {
                return Math.abs(a[0]);
            }
        }

        w = new long[a.length];
        line = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            w[i] = a[i];
            line.add(new ArrayList<>());
        }

        answer = 0;
        dp = new long[a.length];
        visit = new boolean[a.length];
        for (int[] edge : edges) {
           
            line.get(edge[0]).add(edge[1]);
            line.get(edge[1]).add(edge[0]);
        }

        for(int i = 0; i<a.length; i++){
            if (line.get(i).size()>1) {
                answer = findDP(i);
                break;
            }
        }

        return answer;
    }

    static long findDP(int n) {
               visit[n] = true;

        for (int e : line.get(n)) {
            if (visit[e]) {
                continue;
            }

            dp[n] += findDP(e) + Math.abs(w[e]);
            w[n]+= w[e];
        }

        return dp[n];
    }
}