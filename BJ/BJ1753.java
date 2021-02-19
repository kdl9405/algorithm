package BJ;

import java.io.*;
import java.util.*;

/* 
    최단경로 
    
*/

public class BJ1753 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

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

        // Queue<Integer> queue = new LinkedList<>();

        PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>(){

            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1]-o2[1];
            }
            

        });

        queue.offer(new Integer[]{start,0});

        int[] route = new int[v + 1];
        Arrays.fill(route, Integer.MAX_VALUE);
        route[start] = 0;
        boolean[] visit = new boolean[v + 1];

        while (!queue.isEmpty()) {
            Integer[] from = queue.poll();
            if (visit[from[0]]) {
                continue;
            }
            visit[from[0]] = true;

            for (cost cost : road.get(from[0])) {
                if (!visit[cost.to]) {
                    if (route[cost.to] > route[from[0]] + cost.weight) {
                        route[cost.to] = route[from[0]] + cost.weight;
                    }
                    queue.offer(new Integer[]{cost.to,route[cost.to]});
                }
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
