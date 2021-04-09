package BOJ;

import java.io.*;
import java.util.*;

/* 
    타임머신 

    벨만 포드
*/
public class BOJ11657 {

    static int N;
    // static long[][] moveTime;
    static ArrayList<nextStation>[] next;
    static long[] dp;
    static int INF;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // moveTime = new long[N + 1][N + 1];
        next = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            next[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            // moveTime[a][b] = time;
            next[a].add(new nextStation(b, time));

        }

        dp = new long[N + 1];
        INF = 90000000;
        Arrays.fill(dp, INF);

        StringBuilder sb = new StringBuilder();
        if (isLoop()) {
            sb.append("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dp[i] == INF) {
                    sb.append("-1\n");
                } else {
                    sb.append(dp[i] + "\n");
                }
            }
        }

        System.out.println(sb.toString().trim());

    }

    static boolean isLoop() {

        dp[1] = 0;

        boolean update = false;

        for (int k = 1; k < N; k++) {
            update = false;

            for (int i = 1; i <= N; i++) {
                if (dp[i] == INF) {
                    continue;
                }

                for (nextStation root : next[i]) {

                    if (dp[root.station] > dp[i] + root.time) {

                        dp[root.station] = dp[i] + root.time;

                        update = true;
                    }
                }
            }

            if (!update) {
                break;
            }
        }

        if (update) {
            for (int i = 1; i <= N; i++) {
                if (dp[i] == INF) {
                    continue;
                }
                for (nextStation root : next[i]) {

                    if (dp[root.station] > dp[i]+root.time) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

class nextStation{
    int station;
    int time;

    nextStation(int station, int time){
        this.station = station;
        this.time = time;
    }
}