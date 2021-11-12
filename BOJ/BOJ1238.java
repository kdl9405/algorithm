package BOJ;


/* 
    파티
*/

import java.io.*;
import java.util.*;

public class BOJ1238 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        aToB = new ArrayList<>();
        bFromA = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            aToB.add(new HashMap<>());
            bFromA.add(new HashMap<>());
        }

        int a, b, t;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            aToB.get(a).put(b, t);
            bFromA.get(b).put(a, t);

        }

        toTime = dijkstra(aToB);
        fromTime = dijkstra(bFromA);
        
        int max = 0;

        for(int i = 1; i<=N; i++){
            if (toTime[i] == INF || fromTime[i] == INF) {
                continue;
            }
            max = Math.max(max, toTime[i] + fromTime[i]);
        }

        System.out.println(max);

    }

    static int N, M, X;
    static int INF = 10000001;
    static List<HashMap<Integer, Integer>> aToB;
    static List<HashMap<Integer, Integer>> bFromA;
    static int[] toTime;
    static int[] fromTime;
    static boolean[] visit;

    static int[] dijkstra(List<HashMap<Integer, Integer>> roads) {

        int[] time = new int[N + 1];
        Arrays.fill(time, INF);
        visit = new boolean[N + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        pq.add(new int[] { X, 0 });

        while (!pq.isEmpty()) {

            int[] now = pq.poll();

            if (visit[now[0]]) {
                continue;
            }
            visit[now[0]] = true;

            for(int next : roads.get(now[0]).keySet()){

                if (visit[next]) {
                    continue;
                }

                if (time[next] > now[1]+roads.get(now[0]).get(next)) {
                    time[next] = now[1]+roads.get(now[0]).get(next);
                    pq.add(new int[]{next, time[next]});
                }
            }

        }

        return time;
    }

}
