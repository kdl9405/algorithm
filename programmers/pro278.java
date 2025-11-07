package programmers;

import java.util.*;

public class pro278 {

    public static void main(String[] args) {

        int[][] points = {{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}};
        int[][] routes = {{2, 3, 4, 5}, {1, 3, 4, 5}};


        System.out.println(solution(points, routes));
    }

    public static int solution(int[][] points, int[][] routes) {
        int answer = 0;

        // 0 : x, 1: y, 2: robot Index 3: next route Index
        Queue<int[]> now = new ArrayDeque<>();
        Queue<int[]> next = new ArrayDeque<>();
        HashMap<String, Integer> conflict = new HashMap<>();


        for (int i = 0; i < routes.length; i++) {
            int[] point = points[routes[i][0] - 1];
            next.add(new int[] {point[0], point[1], i, 1});
            String key = point[0] + " " + point[1];
            conflict.put(key, conflict.getOrDefault(key, 0) + 1);
        }
        for (String key : conflict.keySet()) {
            if (conflict.get(key) > 1) {
                answer++;
            }
        }

        while (!next.isEmpty()) {

            Queue<int[]> temp = now;
            now = next;
            next = temp;
            conflict.clear();

            while (!now.isEmpty()) {
                int[] robot = now.poll();
                int[] destination = points[routes[robot[2]][robot[3]] - 1];

                if (destination[0] == robot[0] && destination[1] == robot[1]) {

                    robot[3]++;
                    if (robot[3] == routes[robot[2]].length) {
                        continue;
                    }

                    destination = points[routes[robot[2]][robot[3]] - 1];
                }

                if (robot[0] != destination[0]) {
                    if (robot[0] > destination[0]) {
                        robot[0]--;
                    } else {
                        robot[0]++;
                    }
                } else {
                    if (robot[1] > destination[1]) {
                        robot[1]--;
                    } else {
                        robot[1]++;
                    }
                }

                String key = robot[0] + " " + robot[1];
                conflict.put(key, conflict.getOrDefault(key, 0) + 1);

                next.add(new int[] {robot[0], robot[1], robot[2], robot[3]});

            }

            for (String key : conflict.keySet()) {
                if (conflict.get(key) > 1) {
                    answer++;
                }
            }

        }

        return answer;
    }
}
