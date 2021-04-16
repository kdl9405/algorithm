package programmers.month2104;

import java.util.*;

// 

public class so3_copy4 {

    public static void main(String[] args) {

        int[] a = { 2, -4, 2 };
        int[][] edges = { { 0, 1 }, { 1, 2 } };

        System.out.println(solution(a, edges));
    }

    static HashMap<Integer, HashSet<Integer>> line;
    static boolean[] leaf;
    static long answer;
    static int[] link;
    static long[] w;

    public static long solution(int[] a, int[][] edges) {

        int sum = 0;
        for (int x : a) {
            sum += x;
        }

        if (sum != 0) {
            return -1;
        }

        w = new long[a.length];
        for(int i = 0; i<a.length; i++){
            w[i] = a[i];
        }

        answer = 0;
        line = new HashMap<>();
        leaf = new boolean[a.length];
        link = new int[a.length];

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

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
            return link[x] - link[y];
        });

        for (int i = 0; i < a.length; i++) {
            pq.add(i);
            link[i] = line.get(i).size();
        }

        while (pq.size() > 1) {

            int now = pq.poll();

            if (link[now] == 0) {
                continue;
            }

            for (int parent : line.get(now)) {

                if (leaf[parent]) {
                    continue;
                }

                link[parent]--;
                answer += Math.abs(w[now]);
                w[parent] += w[now];

            }
            
            leaf[now] = true;

        }

        return answer;
    }

}
