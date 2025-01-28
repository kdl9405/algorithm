package boj;

import java.io.*;
import java.util.*;

/*
 * 달빛 여우
 * 
 * 시간초과
 */
public class BOJ16118 {

    static final int INF = 2000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] Dp_wolf = new int[n + 1][2];
        int[] Dp_fox = new int[n + 1];

        List<int[]>[] roads = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            roads[i] = new ArrayList<>();
            Dp_fox[i] = INF;
            Arrays.fill(Dp_wolf[i], INF);

        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            roads[a].add(new int[] {b, 2 * d});
            roads[b].add(new int[] {a, 2 * d});
        }

        // fox
        PriorityQueue<fox> qFoxs = new PriorityQueue<>((a, b) -> {
            return a.time - b.time;
        });
        Dp_fox[1] = 0;
        qFoxs.add(new fox(1, 0));

        while (!qFoxs.isEmpty()) {

            fox now = qFoxs.poll();

            int c = now.to;
            int t = now.time;

            if (Dp_fox[now.to] < t) {
                continue;
            }

            for (int[] next : roads[c]) {
                int to = next[0];
                int time = t + next[1];

                if (Dp_fox[to] > time) {
                    Dp_fox[to] = time;
                    qFoxs.add(new fox(to, time));
                }
            }
        }

        // wolf
        PriorityQueue<wolf> qWolves = new PriorityQueue<>((a, b) -> {
            return a.time - b.time;
        });

        Dp_wolf[1][0] = 0;

        qWolves.add(new wolf(1, 0, 0));

        while (!qWolves.isEmpty()) {

            wolf now = qWolves.poll();

            int c = now.to;
            int t = now.time;
            int s = now.state;

            if (Dp_wolf[c][s] < t) {
                continue;
            }

            for (int[] next : roads[c]) {
                int to = next[0];
                int time = t;
                int ns = -1;

                if (s == 1) {
                    time += (next[1] * 2);
                    ns = 0;
                } else {
                    time += (next[1] / 2);
                    ns = 1;
                }

                if (Dp_wolf[to][ns] > time) {
                    Dp_wolf[to][ns] = time;
                    qWolves.add(new wolf(to, time, ns));
                }
            }

        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (Dp_fox[i] < Math.min(Dp_wolf[i][0], Dp_wolf[i][1])) {
                count++;
            }
        }

        System.out.println(count);
    }
}


class wolf {

    int state;
    int time;
    int to;

    public wolf(int to, int time, int state) {
        this.to = to;
        this.time = time;
        this.state = state;
    }
}


class fox {
    int to;
    int time;

    public fox(int to, int time) {
        this.to = to;
        this.time = time;
    }
}
