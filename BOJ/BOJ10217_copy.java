package BOJ;

/* 
    KCM Travel

    1. 티켓정보 저장 - List<List<int[]>>
    2. 1번을 pq에 담아서 가장 시간순으로 뽑아서 다음 경로를 추적
*/

import java.io.*;
import java.util.*;

public class BOJ10217_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int u, v, c, d;
        int INF = 1000000;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            tickets = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                tickets.add(new ArrayList<>());
            }
            for (int i = 0; i < k; i++) {

                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());

                tickets.get(u).add(new int[] { v, c, d, i });
            }

            visit = new boolean[n + 1];
            used = new boolean[k];
            answer = INF;
            visit[1] = true;
            dfs(1, 0, 0);

            if (answer == INF) {
                sb.append("Poor KCM" + "\n");
            } else {
                sb.append(answer + "\n");
            }
        }

        System.out.println(sb.toString().trim());
    }

    static int n, m, k;
    static List<List<int[]>> tickets;
    static boolean[] used;
    static boolean[] visit;
    static int answer;

    static void dfs(int from, int cost, int distance) {

        if (cost > m || distance >= answer) {
            return;
        }

        if (from == n) {
            if (cost <= m) {
                answer = Math.min(answer, distance);
            }
            return;
        }

        for (int[] ticket : tickets.get(from)) {
            if (used[ticket[3]] || visit[ticket[0]]) {
                continue;
            }

            if (ticket[1] + cost > m) {
                continue;
            }
            visit[ticket[0]] = true;
            used[ticket[3]] = true;
            dfs(ticket[0], cost + ticket[1], distance + ticket[2]);
            visit[ticket[0]] = false;
            used[ticket[3]] = false;

        }
    }
}
