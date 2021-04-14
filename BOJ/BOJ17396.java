package BOJ;

import java.io.*;
import java.util.*;

/* 
    백도어
*/
public class BOJ17396 {

    static int N, M;
    static int[] possible; // 0은 가능, 1은 불가
    static ArrayList<ArrayList<road>> roads; 
    static long[] dist;
    static long INF = (long) Math.pow(100000, 2);

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        possible = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        possible[N - 1] = 0;

        roads = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            roads.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            roads.get(a).add(new road(b, t));
            roads.get(b).add(new road(a, t));

        }

        dist = new long[N];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        PriorityQueue<road> queue = new PriorityQueue<>((p1, p2) -> {
            if (p1.time < p2.time)
                return -1;
            else if (p1.time == p2.time)
                return 0;
            else
                return 1;
        });
        queue.add(new road(0, 0));

        while (!queue.isEmpty()) {

            road now = queue.poll();

            if (possible[now.dest] == 1) {
                continue;
            }

            possible[now.dest] = 1;

            if (now.dest == N - 1) {
                System.out.println(dist[N - 1]);
                return;
            }

            for (road next : roads.get(now.dest)) {

                long temp = now.time + next.time;

                if (possible[next.dest] == 0 && temp < dist[next.dest]) {
                    dist[next.dest] = temp;
                    queue.add(new road(next.dest, temp));
                }
            }
        }

        System.out.println(-1);

    }
}

class road {
    int dest;
    long time;

    public road(int dest, long time) {
        this.dest = dest;
        this.time = time;
    }
}
