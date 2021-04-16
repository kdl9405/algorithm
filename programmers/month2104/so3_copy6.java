package programmers.month2104;

import java.util.*;

//  DFS  => 시간초과 4개

public class so3_copy6 {

    public static void main(String[] args) {

        int[] a = { -5, 0, 2, 1, 2 };
        int[][] edges = { { 0, 1 }, { 3, 4 }, { 2, 3 }, { 0, 3 } };

        System.out.println(solution(a, edges));
    }

    // static HashMap<Integer, HashSet<Integer>> line;
    static ArrayList<ArrayList<Integer>> line;
    static HashSet<Integer> nodeSet;
    static boolean[] isleaf;
    static long answer;
    static long[] w;

    public static long solution(int[] a, int[][] edges) {

        answer = 0;

        isleaf = new boolean[a.length];
        nodeSet = new HashSet<>();
        w = new long[a.length];
        line = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            w[i] = a[i];
            line.add(new ArrayList<>());
            answer += a[i];
            nodeSet.add(i);
        }

        if (answer != 0) {
            return -1;
        }

        for (int[] edge : edges) {
            line.get(edge[0]).add(edge[1]);
            line.get(edge[1]).add(edge[0]);
        }

        while (true) {

            List<int[]> leafList = findLeaf();

            if (leafList.isEmpty() || leafList.size() < 2) {
                break;
            }

            for (int[] leaf : leafList) {
                moveWeight(leaf);
            }
        }

        return answer;
    }

    static List<int[]> findLeaf() {

        List<int[]> leafList = new ArrayList<>();
        for (int i : nodeSet) {
          
            int count = 0;
            int root = 0;
            for (int e : line.get(i)) {
                if (nodeSet.contains(e)) {
                    count++;
                    root = e;
                }
            }

            if (count == 1) {
                leafList.add(new int[] { i, root });
            }
        }

        return leafList;
    }

    static void moveWeight(int[] leaf) {

        if (isleaf[leaf[0]]) {
            return;
        }

        isleaf[leaf[0]] = true;

        answer += Math.abs(w[leaf[0]]);
        w[leaf[1]] += w[leaf[0]];

        nodeSet.remove(leaf[0]);

        return;
    }
}