package BOJ;

import java.io.*;
import java.util.*;

/* 
    특정한 최단 경로
*/
public class BOJ1504 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        roads = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            roads.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            roads.get(a).add(new road(b, c));
            roads.get(b).add(new road(a, c));
        }

        distance = new int[n + 1];
        visit = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        int dis_a = dijkstra(1, v1) + dijkstra(v1, v2) +dijkstra(v2, n);
        int dis_b = dijkstra(1, v2) + dijkstra(v2, v1) +dijkstra(v1, n);
        
        dis_a = Math.min(dis_a, dis_b);

        if (dis_a > INF) {
            System.out.println(-1);
        }else{
            System.out.println(dis_a);
        }

    }

    static final int INF = 200000000;
    static List<List<road>> roads;
    static int[] distance;
    static boolean[] visit;

    static int dijkstra(int start, int end) {

        Arrays.fill(distance, INF);
        Arrays.fill(visit, false);

        PriorityQueue<road> pq = new PriorityQueue<>((a, b) -> {
            return a.dist - b.dist;
        });
        pq.add(new road(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            road now = pq.poll();

            if (visit[now.to]) {
                continue;
            }

            visit[now.to] = true;

            for(road next : roads.get(now.to)){
                if (visit[next.to]) {
                    continue;
                }
                
                if (distance[next.to] > distance[now.to]+next.dist) {
                    distance[next.to] = distance[now.to]+next.dist;
                    pq.add(new road(next.to, distance[next.to]));
                }

            }
           
        }   

        return distance[end];

    }

}

class road {
    int to;
    int dist;

    public road(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }

}
