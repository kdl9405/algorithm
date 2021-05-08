package programmers;

import java.util.*;

/*
    [카카오 인턴] 동굴 탐험

    1) 부모노드 저장,  / order 저장
    2) order의 앞순서와 

*/
public class pro183 {

    public static void main(String[] args) {

        int n = 9;
        int[][] path = { { 0, 1 }, { 0, 3 }, { 0, 7 }, { 8, 1 }, { 3, 6 }, { 1, 2 }, { 4, 7 }, { 7, 5 } };
        int[][] order = { { 4, 1 }, { 8, 7 }, { 6, 5 } };

        solution(n, path, order);
    }

    public static boolean solution(int n, int[][] path, int[][] order) {
        answer = true;

        List<List<Integer>> line = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            line.add(new ArrayList<>());
        }

        for (int[] p : path) {
            line.get(p[0]).add(p[1]);
            line.get(p[1]).add(p[0]);
        }

        parent = new int[n];
        visit = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {

            int p = queue.poll();

            visit[p] = true;

            for (Integer child : line.get(p)) {
                if (visit[child]) {
                    continue;
                }
                parent[child] = p;
                queue.add(child);
            }
        }

        for (int[] o : order) {
            queue = new LinkedList<>();
            if (check[o[1]]) {
                continue;
            }

            visit = new boolean[n];
            visit[o[1]] = true;

            while (!queue.isEmpty()) {

                int x = queue.poll();
                check[x] = true;

                if (before.containsKey(x)) {
                    if (visit[before.get(x)]) {
                        return false;
                    }
                    visit[before.get(x)] = true;
                    queue.add(before.get(x));
                }

                if (answer) {

                }
            }

        }

        return answer;
    }

    static int[] parent;
    static boolean[] visit, check;
    static HashMap<Integer, Integer> before;
    static boolean answer;
    static HashSet<Integer> set;

    static List<Integer> findParent(int x) {
        List<Integer> list = new LinkedList<>();

        if (before.containsKey(x)) {
            if (!visit[before.get(x)]) {
                visit[before.get(x)] = true;
                list.add(before.get(x));
            }
        }

        while (parent[x] != 0) {
            x = parent[x];
            if (before.containsKey(x)) {
                if (!visit[before.get(x)]) {
                    visit[before.get(x)] = true;
                    list.add(before.get(x));
                }
            }
        }

        return list;
    }

}
