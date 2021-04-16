package programmers.month2104;

import java.util.*;

//  DFS  => 통과

public class so3_copy_fin {

    public static void main(String[] args) {

        long beforeUsedMem = Runtime.getRuntime().freeMemory();

        int[] a = { -6, 1, 2, 1, 2 };
        int[][] edges = { { 0, 1 }, { 3, 4 }, { 2, 3 }, { 0, 3 } };

        System.out.println(solution(a, edges));

        long afterUsedMem = Runtime.getRuntime().freeMemory();
        long actualMemUsed = afterUsedMem - beforeUsedMem;

        System.out.println(actualMemUsed);
    }

    static ArrayList<ArrayList<Integer>> line;
    static long[] w;

    public static long solution(int[] a, int[][] edges) {

        long answer = 0;

        w = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            w[i] += a[i];
            answer += a[i];
        }

        if (answer != 0) {
            return -1;
        }

        line = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            line.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            line.get(edge[0]).add(edge[1]);
            line.get(edge[1]).add(edge[0]);
        }

        answer = dfs(0, -1);

        return answer;
    }

    static long dfs(int n, int parent) {

        long temp = 0;

      /*   for (int next : line.get(n)) {
            if (next != parent) {
                temp += dfs(next, n);
            }
        } */

        for (int i = 0; i < line.get(n).size(); i++) {
            int next = line.get(n).get(i);
            if (next != parent) {
                temp += dfs(next, n);
            }
        }

        if (parent != -1) {
            w[parent] += w[n];
        }

        return temp + Math.abs(w[n]);

    }

}