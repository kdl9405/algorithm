package programmers.month2104;

import java.util.*;

//  통과...

public class so3_copy4 {

    public static void main(String[] args) {

        int[] a = { 2, -4, 2 };
        int[][] edges = { { 0, 1 }, { 1, 2 } };

        System.out.println(solution(a, edges));
    }

    static ArrayList<ArrayList<Integer>> line;
    static boolean[] isleaf;
    static long answer;
    static int[] link;
    static long[] w;

    public static long solution(int[] a, int[][] edges) {

        answer = 0;

        for (int x : a) {
            answer += x;
        }

        if (answer != 0) {
            return -1;
        }

        w = new long[a.length];
        line = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            w[i] = a[i];
            line.add(new ArrayList<>());
        }

        isleaf = new boolean[a.length];
        link = new int[a.length];

        for (int[] edge : edges) {
            line.get(edge[0]).add(edge[1]);
            line.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < link.length; i++) {
            link[i] = line.get(i).size();
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < a.length; i++) {
            if (link[i] == 1) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            isleaf[now] = true;


            for (int parent : line.get(now)) {

                if (isleaf[parent]) {
                    continue;
                }

                link[parent]--;
                answer += Math.abs(w[now]);
                w[parent] += w[now];

                if (link[parent] == 1) {
                    queue.add(parent);
                }
            }
        }

        return answer;
    }
}
