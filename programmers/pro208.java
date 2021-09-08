package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

/* 
    배달
*/

public class pro208 {

    public static void main(String[] args) {
        int N = 6;
        int[][] road = { { 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5, 2 }, { 3, 5, 3 }, { 5, 6, 1 } };
        int K = 4;

        System.out.println(solution(N, road, K));

    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        time = new int[N + 1][N + 1];

        for (int[] r : road) {
            if (time[r[0]][r[1]] == 0 || time[r[0]][r[1]] > r[2]) {
                time[r[0]][r[1]] = r[2];
                time[r[1]][r[0]] = r[2];
            }
        }

        int[] dijkstra = new int[N+1];
        Arrays.fill(dijkstra, Integer.MAX_VALUE);
        dijkstra[1] = 0;

        visit = new boolean[N+1];

        PriorityQueue<Integer> pq = new PriorityQueue<>((q1, q2) -> {
            return dijkstra[q1] - dijkstra[q2];
        });
        pq.add(1);

        while (!pq.isEmpty()) {
            int from = pq.poll();

            if (visit[from]) {
                continue;
            }

            visit[from] = true;

            for(int i = 1; i<=N; i++){
                if (from == i || time[from][i] == 0) {
                    continue;
                }

                if (dijkstra[i] > dijkstra[from] + time[from][i]) {
                    dijkstra[i] = dijkstra[from] + time[from][i];
                    pq.add(i);
                }
            }
        }

        for (int i = 1; i <= N; i++) {

            if (dijkstra[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    static int[][] time;
    static boolean[] visit;

}
