package programmers.month2104;

import java.util.*;

public class so4_copy {

    public static void main(String[] args) {

        int n = 5;
        int z = 5;
        int[][] roads = { { 1, 2, 3 }, { 0, 3, 2 } };
        long queries[] = { 0, 1, 2, 3, 4, 5, 6 };

        long[] answer = solution(n, z, roads, queries);

        for (long a : answer) {
            System.out.println(a + " ");
        }

    }

    static HashMap<Integer, List<int[]>> cost; // 출발 int{도착, 가중치}
    static long count;

    public static long[] solution(int n, int z, int[][] roads, long[] queries) {
        long[] answer = new long[queries.length];

        cost = new HashMap<>();
        for (int[] road : roads) {
            if (!cost.containsKey(road[0])) {
                cost.put(road[0], new ArrayList<>());
            }

            cost.get(road[0]).add(new int[] { road[1], road[2] });
        }

        for (int i = 0; i < queries.length; i++) {
            if (queries[i] == 0) {
                answer[i] = 0;
            } else if (queries[i] == z) {
                answer[i] = 1;
            }

            count = -1;

            findroot(0, 0, 0, queries[i], z);

            answer[i] = count;
        }

        return answer;
    }

    static void findroot(int start, long c, long w, long q, int z) {

        if (count >= 0 && c > count) {
            return;
        }

        if (w == q) {
            if (count < 0) {
                count = c;
            } else {
                count = Math.min(count, c);
            }
            return;
        }

        if (w > q) {
            return;
        }

        findroot(start, c + 1, w + z, q, z); // 움직이자 않고 +z

        if (cost.containsKey(start)) {
            for (int[] road : cost.get(start)) {
                findroot(road[0], c + 1, w + road[1], q, z);
            }
        }

        for (int city : cost.keySet()) {
            if (city == start) {
                continue;
            }

            for (int[] road : cost.get(city)) {
                findroot(road[0], c + 2, w + road[1], q, z);
            }
        }
    }
}
