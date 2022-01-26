package programmers;

/* 
    양과 늑대
*/

import java.util.*;

public class pro233_copy {

    public static void main(String[] args) {

        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8},{8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9} };

        new pro233_copy().solution(info, edges);
    }

    public int solution(int[] info, int[][] edges) {

        init(info, edges);

        countNodes(0, -1, info);

        int answer = findMaxSheep(info);

        System.out.println(answer);

        return answer;
    }

    List<List<Integer>> links;
    int[][] nodes;

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

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (info[a] == 1 && info[b] == 1) {

                if ((nodes[b][0] - nodes[b][1]) == (nodes[a][0] - nodes[a][1])) {
                    return nodes[b][0] - nodes[a][0];
                }

                return (nodes[b][0] - nodes[b][1]) - (nodes[a][0] - nodes[a][1]);
            }

            return info[a] - info[b];
        });

        pq.add(0);

        int sheep = 0;
        int wolf = 0;

        boolean[] visit = new boolean[info.length];
        visit[0] = true;
        while (!pq.isEmpty()) {
            System.out.println(pq);
            int now = pq.poll();

            if (info[now] == 0) {
                sheep++;
            } else {
                wolf++;
            }

            System.out.println(now + " " + sheep + " " + wolf);

            if (sheep == wolf) {
                break;
            }

            for (int next : links.get(now)) {
                if (!visit[next]) {
                    visit[next] = true;
                    if (nodes[next][0] != 0) {
                        pq.add(next);
                    }
                }
            }
        }

        return sheep;

    }
}
