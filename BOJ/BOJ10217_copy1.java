package BOJ;

/* 
    KCM Travel

    1. 티켓정보 저장 - List<List<int[]>>
    2. 1번을 pq에 담아서 가장 시간순으로 뽑아서 다음 경로를 추적
*/

import java.io.*;
import java.util.*;

public class BOJ10217_copy1 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n, m, k;
        int u, v, c, d;
        int INF = 1000000;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            List<List<int[]>> tickets = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                tickets.add(new ArrayList<>());
            }
            while (k-- > 0) {

                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());

                tickets.get(u).add(new int[] { v, c, d });
            }

            boolean[] visit = new boolean[n + 1];

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {

                if(a[2] == b[2]){
                    return a[1]-b[1];
                }
                return a[2] - b[2];
            });
            pq.add(new int[] { 1, 0, 0 });

            int[] dist = new int[n + 1];
            Arrays.fill(dist, INF);
            dist[1] = 0;

            while (!pq.isEmpty()) {
                int now[] = pq.poll();

                if (visit[now[0]]) {
                    continue;
                }

                if(now[1] > m){
                    continue;
                }

                visit[now[0]] = true;

                for (int[] ticket : tickets.get(now[0])) {
                    if (visit[ticket[0]]) {
                        continue;
                    }
                    if (ticket[1] + now[1] > m) {
                        continue;
                    }
                    
                    if (dist[ticket[0]] > dist[now[0]]+ ticket[2]) {
                        dist[ticket[0]] = dist[now[0]]+ ticket[2];

                        System.out.println("from = "+now[0] +"  to = " +ticket[0] + "  cost = "+(ticket[1]+now[1])+ " dist = " + dist[ticket[0]]);

                        if (ticket[0] != n) {
                            pq.add(new int[]{ticket[0],ticket[1]+now[1],dist[ticket[0]]});
                        }
                    }
                }
            }

            if (dist[n] == INF) {
                sb.append("Poor KCM");
            } else {
                sb.append(dist[n]);
            }
            sb.append("\n");

        }

        System.out.println(sb.toString().trim());
    }
}
