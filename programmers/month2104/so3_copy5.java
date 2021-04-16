package programmers.month2104;

import java.util.*;

//  DFS  => 통과

public class so3_copy5 {

    public static void main(String[] args) {

        int[] a = { -6, 1, 2, 1, 2 };
        int[][] edges = { { 0, 1 }, { 3, 4 }, { 2, 3 }, { 0, 3 } };

        System.out.println(solution(a, edges));
    }

    // static HashMap<Integer, HashSet<Integer>> line;
    static ArrayList<ArrayList<Integer>> line;
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

        visit = new boolean[a.length];
        for (int[] edge : edges) {

            line.get(edge[0]).add(edge[1]);
            line.get(edge[1]).add(edge[0]);
        }

        dfs(1);

        for(int i = 0; i<w.length; i++){
            System.out.println(i+" " +w[i]);
        }

        return answer;
    }

    static void dfs(int n) {

       
        if (visit[n]) {
            return;
        }
      
        visit[n] = true;

        if(line.get(n).isEmpty()){
            return;
        }
        for (int e : line.get(n)) {
            if (visit[e]) {
                continue;
            }

            dfs(e);
            answer += Math.abs(w[e]);
            w[n] += w[e];
        }

        return;
    }
}