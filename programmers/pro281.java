package programmers;
/*
 * 코딩테스트 연습 연습문제 부대복귀
 */


import java.util.*;

public class pro281 {

    public static void main(String[] args) {
        int n = 3;
        int[][] roads = {{1, 2}, {2, 3}};
        int[] sources = {2, 3};
        int destination = 1;

        int[] result = solution(n, roads, sources, destination);

        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {

        linked = new HashMap<>();

        for (int[] road : roads) {

            if (!linked.containsKey(road[0]))
                linked.put(road[0], new HashSet<>());

            if (!linked.containsKey(road[1]))
                linked.put(road[1], new HashSet<>());

            linked.get(road[0]).add(road[1]);
            linked.get(road[1]).add(road[0]);
        }

        distance = new int[n + 1];
        Arrays.fill(distance, -1);

        distance[destination] = 0;
        findDistance(destination);

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }

        return answer;
    }

    private static HashMap<Integer, Set<Integer>> linked;
    private static int[] distance;

    private static void findDistance(int destination) {

        Queue<int[]> dist = new ArrayDeque<>();
        dist.add(new int[] {destination, 0});

        while (!dist.isEmpty()) {
            int[] point = dist.poll();

            for (int next : linked.get(point[0])) {
                if (distance[next] != -1)
                    continue;

                distance[next] = point[1] + 1;
                dist.add(new int[] {next, point[1] + 1});
            }
        }
    }
}
