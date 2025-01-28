package boj;

import java.io.*;
import java.util.*;

/*
 * 최단경로 메모리초과
 */

public class BOJ1753_copy2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        // int[][] cost = new int[v+1][v+1];
        List<ArrayList<cost>> road = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            road.add(new ArrayList<cost>());
        }

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            road.get(from).add(new cost(from, to, weight));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        int[] route = new int[v + 1];
        Arrays.fill(route, Integer.MAX_VALUE);
        route[start] = 0;
        boolean[] visit = new boolean[v + 1];

        while (!queue.isEmpty()) {
            int from = queue.poll();
            if (visit[from]) {
                continue;
            }
            visit[from] = true;

            for (cost cost : road.get(from)) {
                route[cost.to] = Math.min(route[cost.to], route[from] + cost.weight);
                queue.offer(cost.to);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (route[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(route[i]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

}


class cost {
    int from;
    int to;
    int weight;

    public cost(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
