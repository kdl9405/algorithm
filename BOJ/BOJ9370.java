package BOJ;

/* 
    미확인 도착지

    1. 각 도로의 거리를 *2해서 저장. g-h 사이의 거리는 +1  
        => 나중에 최단거리를 %2 했을 때, 1이 나오면 g-h 도로를 지나갔다는 것! 
    2. 다익스트라로 최단거리 산출

*/

import java.io.*;
import java.util.*;

public class BOJ9370 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            roads = new int[n + 1][n + 1];
            dist = new int[n+1];
            visit = new boolean[n+1];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(roads[i], 10000000);
            }
            Arrays.fill(dist, 10000000);


            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) * 2;

                roads[a][b] = d;
                roads[b][a] = d;
            }

            roads[g][h] -= 1;
            roads[h][g] -= 1;

            List<Integer> dest = new ArrayList<>();
            while (t-- > 0) {
                dest.add(Integer.parseInt(br.readLine()));
            }

            dijkstra(s);
        
            Collections.sort(dest);

            StringBuilder temp = new StringBuilder();

            for(int d : dest){
                if (dist[d]%2 == 1) {
                    temp.append(d+" ");
                }
            }

            sb.append(temp.toString().trim() + "\n");

        }

        System.out.println(sb.toString().trim());
    }

    static int[][] roads;
    static int[] dist;
    static boolean[] visit;

    static void dijkstra(int start) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        pq.add(new int[] { start, 0 });
        dist[start] = 0;


        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (visit[now[0]]) {
                continue;
            }
            visit[now[0]] = true;

            for (int i = 1; i < roads.length; i++) {
                if (!visit[i] && dist[i] > dist[now[0]] + roads[now[0]][i]) {
                    dist[i] = dist[now[0]] + roads[now[0]][i];
                    pq.add(new int[] { i, dist[i] });
                }
            }
        }

    }
}