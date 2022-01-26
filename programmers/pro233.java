package programmers;

/* 
    양과 늑대
*/

import java.util.*;

public class pro233 {

    public static void main(String[] args) {

        int[] info = { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 };
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 4 }, { 0, 8 }, { 8, 7 }, { 9, 10 }, { 9, 11 }, { 4, 3 }, { 6, 5 },
                { 4, 6 }, { 8, 9 } };

        new pro233().solution(info, edges);
    }

    public int solution(int[] info, int[][] edges) {

        init(info, edges);

        countNodes(0, -1, info);

        int answer = findMaxSheep(info);

        return answer;
    }

    List<List<Integer>> links;
    int[][] nodes;

    private class Case {
        int num;
        int sheep;
        int wolf;
        int isLinked;
        int isVisited;

        Case(int num, int sheep, int wolf, int isLinked, int isVisited) {
            this.num = num;
            this.sheep = sheep;
            this.wolf = wolf;
            this.isLinked = isLinked;
            this.isVisited = isVisited;
        }
    }

    void init(int[] info, int[][] edges) {
        links = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            links.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            links.get(edge[0]).add(edge[1]);
            links.get(edge[1]).add(edge[0]);
        }

        nodes = new int[info.length][2];
    }

    int[] countNodes(int num, int parent, int[] info) {

        nodes[num][info[num]] = 1;

        for (int child : links.get(num)) {
            if (child != parent) {

                countNodes(child, num, info);
                nodes[num][0] += nodes[child][0];
                nodes[num][1] += nodes[child][1];
            }
        }

        return nodes[num];

    }

    int findMaxSheep(int[] info) {

        Queue<Case> queue = new LinkedList<>();

        queue.add(new Case(0, 1, 0, 1, 1));

        int sheep = 0;

        while (!queue.isEmpty()) {
            Case now = queue.poll();

            sheep = Math.max(sheep, now.sheep);

            for (int next : links.get(now.num)) {
                now.isLinked |= (1 << next);
            }

            for (int next = 1; next < info.length; next++) {

                if (((now.isLinked | (1<<next)) != now.isLinked) ||((now.isVisited | (1 << next)) == now.isVisited)) {
                    continue;
                }

                if (info[next] == 0) {
                    queue.add(new Case(next, now.sheep + 1, now.wolf, now.isLinked, now.isVisited | (1 << next)));
                } else {
                    if (now.sheep > now.wolf + 1) {
                        queue.add(new Case(next, now.sheep, now.wolf + 1, now.isLinked, now.isVisited | (1 << next)));
                    }
                }
            }
        }

        return sheep;

    }
}
