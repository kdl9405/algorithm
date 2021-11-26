package BOJ;

/* 
    KCM Travel

    1. 티켓정보 저장 - List<List<int[]>>  // DP[][] i공항에 j머니로 도착하는 최소 시간 
    2. 1번을 pq에 담아서 가장 시간순으로 뽑아서 다음 경로를 추적
    
*/

import java.io.*;
import java.util.*;

public class BOJ10217 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            tickets = new ArrayList<>();
            dp = new int[n + 1][m + 1];
            visit = new boolean[n + 1];

            for (int i = 0; i <= n; i++) {
                tickets.add(new ArrayList<>());
                Arrays.fill(dp[i], INF);
            }

            while (k-- > 0) {

                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());

                tickets.get(u).add(new int[] { v, c, d });
            }

            dijkstra();

            Arrays.sort(dp[n]);

            int answer = dp[n][0];

           
            // int answer = Integer.MAX_VALUE;

            // for (int i = 1; i <= m; i++) {
            //     answer = Math.min(answer, dp[n][i]);
            // }

            if (answer == INF) {
                sb.append("Poor KCM");
            } else {
                sb.append(answer);
            }
            sb.append("\n");

        }

        System.out.println(sb.toString().trim());
    }

    static int n, m, k;
    static int u, v, c, d;
    static int INF = 1000000;
    static List<List<int[]>> tickets;
    static int[][] dp;
    static boolean[] visit;

    static void dijkstra() {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {

            // if (a[2] == b[2]) {
            // return a[1] - b[1];
            // }
            return a[1] - b[1];
        });
        pq.add(new int[] { 1, 0 });

        dp[1][0] = 0;

        while (!pq.isEmpty()) {
            int now[] = pq.poll();

            if (visit[now[0]]) {
                continue;
            }
            visit[now[0]] = true;

            // if (now[0] == n) {
            // break;
            // }

            // if (dp[now[0]][now[1]] < now[2]) {
            // continue;
            // }
            // dp[now[0]][now[1]] = now[2];

            for (int[] ticket : tickets.get(now[0])) {

                int time = INF;

                for (int i = 0; i <= m - ticket[1]; i++) {
                    if (dp[now[0]][i] == INF) {
                        continue;
                    }

                    dp[ticket[0]][i + ticket[1]] = Math.min(dp[ticket[0]][i + ticket[1]], dp[now[0]][i] + ticket[2]);
                    time = Math.min(time, dp[ticket[0]][i + ticket[1]] );
                }

                pq.add(new int[]{ticket[0],time});

                // int cost = now[1] + ticket[1];
                // int time = now[2] + ticket[2];

                // if (cost > m) {
                // continue;
                // }

                // if (dp[ticket[0]][cost] < time) {
                // continue;
                // }

                // for (int i = cost; i <= m; i++) {
                // if (dp[ticket[0]][i] > time) {
                // dp[ticket[0]][i] = time;
                // pq.add(new int[] { ticket[0], cost, time });
                // }
                // }

            }
        }
    }
}
