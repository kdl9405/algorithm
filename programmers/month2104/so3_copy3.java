package programmers.month2104;

import java.util.*;

// 

public class so3_copy3 {

    public static void main(String[] args) {

        int[] a = { 2, -2 };
        int[][] edges = { { 0, 1 } };

        System.out.println(solution(a, edges));
    }

    static long dp[];
    static long[] w;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> tree;

    public static long solution(int[] a, int[][] edges) {

        w = new long[a.length];
        for(int i = 0; i<a.length; i++){
            w[i] = a[i];
        }

        dp = new long[a.length];
        tree = new ArrayList<>();
        visit = new boolean[a.length];

        for (int i = 0; i < a.length; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);

        }

        long answer = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                answer = buildTree(i, -1);
                if (w[i] != 0) {
                    return -1;
                }
                break;
            }
        }

        return answer;

    }

    static long buildTree(int root, int parent) {

        if (dp[root] != 0) {
            return dp[root];
        }

        visit[root] = true;

        for (int child : tree.get(root)) {
            if (child != parent && !visit[root]) {
                dp[root] += buildTree(child, root);
                w[root] += w[child];

            }
        }

        return dp[root] + Math.abs(w[root]);
    }

}