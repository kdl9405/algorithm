package programmers.month2104;

import java.util.*;

public class so4 {

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

    static HashMap<Integer, List<int[]>> to; // 출발 int{도착, 가중치}
 //   static HashMap<Integer, List<int[]>> from; // 도착 int{출발, 가중치}

    static HashMap<Long, >

    static long count;
    //static long[] dp;

    public static long[] solution(int n, int z, int[][] roads, long[] queries) {
        long[] answer = new long[queries.length];

        to = new HashMap<>();
        from = new HashMap<>();

        for (int[] road : roads) {
            if (!to.containsKey(road[0])) {
                to.put(road[0], new ArrayList<>());
            }

            to.get(road[0]).add(new int[] { road[1], road[2] });

            if (!from.containsKey(road[1])) {
                from.put(road[1], new ArrayList<>());
            }

            from.get(road[1]).add(new int[] { road[0], road[2] });
        }

        dp = new long[10000001];

        Arrays.fill(dp, -1);

        for (int i = 0; i < queries.length; i++) {
            if (queries[i] == 0) {
                answer[i] = 0;
            } else if (queries[i] == z) {
                answer[i] = 1;
            }

            if (queries[i] < dp.length) {

            } else {
                count = -1;
                findroot(0, 0, 0, queries[i], z);
                answer[i] = count;
            }

        }

        return answer;
    }

    static long findDP(long q, long w, int z){

        if (dp[(int)q] != -1) {
            return dp[(int)q];
        }

        long temp = dp[(int)q-z]+1;

        for (int city : to.keySet()) {
            if (city == start) {
                continue;
            }

            for (int[] road : to.get(city)) {
                
            }
        }


        return dp[(int)q] = temp;
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

        if (to.containsKey(start)) {
            for (int[] road : to.get(start)) {
                findroot(road[0], c + 1, w + road[1], q, z);
            }
        }

        for (int city : to.keySet()) {
            if (city == start) {
                continue;
            }

            for (int[] road : to.get(city)) {
                findroot(road[0], c + 2, w + road[1], q, z);
            }
        }
    }
}
