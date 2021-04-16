package programmers.month2104;

import java.util.*;

// 

public class so3_copy {

    public static void main(String[] args) {

        int[] a = {2, -4, 2 };
        int[][] edges = { { 0, 1 }, { 1, 2 }};


        System.out.println(solution(a, edges));
    }

    static HashMap<Integer, HashSet<Integer>> line;
    static long[] dp;
    static boolean[] leaf;
    static long answer;

    public static long solution(int[] a, int[][] edges) {

        int sum = 0;
        for (int x : a) {
            sum += x;
        }

        if (sum != 0) {
            return -1;
        }

        answer = 0;
        line = new HashMap<>();
        dp = new long[a.length];
        leaf = new boolean[a.length];

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

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            return line.get(n1).size() - line.get(n2).size();
        });

        for (int i = 0; i < a.length; i++) {
            pq.add(i);
        }

        while (pq.size() > 1) {

            int now = pq.poll();

            System.out.println("now  = " + now);
            
            for(int root : line.get(now)){
                // if (leaf[root]) {
                //     continue;
                // }
                System.out.println("before  "+root +" " + line.get(root));

                answer += Math.abs(a[now]);
                a[root] += a[now];
                line.get(root).remove(now);
                System.out.println("after  "+root +" " + line.get(root));
                // break;
            }

            // leaf[now] = true;

        }

        return answer;
    }

}
