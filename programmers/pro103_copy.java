package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 배달
 * 50.0 / 100.0
 */
public class pro103_copy {

    public static void main(String[] args) {
        int N = 6;
        int[][] road = { { 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5, 2 }, { 3, 5, 3 }, { 5, 6, 1 } };
        int K = 4;

        System.out.println(solution(N, road, K));
    }

    static int solution(int N, int[][] road, int K) {
        int answer = 0;

        boolean[] visit = new boolean[N + 1];
        long[] arr = new long[N + 1];
        Arrays.fill(arr, Long.MAX_VALUE);
        arr[1] = 0;

        HashMap<HashSet<Integer>, Integer> hash = new HashMap<>();

        for (int[] r : road) {
            HashSet<Integer> temp = new HashSet<>();
            temp.add(r[0]);
            temp.add(r[1]);
            if (hash.containsKey(temp)) {
                hash.put(temp, Math.min(hash.get(temp), r[2]));
            } else {
                hash.put(temp, r[2]);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            System.out.println(queue);
            System.out.println(hash);


            int from = queue.poll();
            visit[from] = true;

            HashSet<HashSet<Integer>> used = new HashSet<>();

            for (HashSet<Integer> set : hash.keySet()) {
                if (set.contains(from)) {
                    used.add(set);
                    for (Integer to : set) {
                        if (to != from) {
                            arr[to] = Math.min(arr[to], arr[from] + hash.get(set));
                            if (!visit[to]) {
                                queue.offer(to);
                            }
                        }
                    }

                }
            }
            for(HashSet<Integer> set : used){
                hash.remove(set);
            }
        }

        for (int i = 1; i <= N; i++) {

            System.out.println(i +"   " + arr[i]);
            if (arr[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

}