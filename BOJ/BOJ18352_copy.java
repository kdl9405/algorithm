package BOJ;

/* 
    특정 거리의 도시 찾기

*/

import java.io.*;
import java.util.*;

public class BOJ18352_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Integer>> roads = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            roads.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            roads.get(a).add(b);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        pq.add(new int[] { X, 0 });
        boolean[] visit = new boolean[N + 1];

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty()) {

            int[] now = pq.poll();

            if (visit[now[0]]) {
                continue;
            }
            visit[now[0]] = true;

            if (now[1] == K) {
                result.add(now[0]);
            }

            if (now[1] > K) {
                break;
            }

            for (int next : roads.get(now[0])) {
                if (visit[next]) {
                    continue;
                }

                pq.add(new int[] { next, now[1] + 1 });
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);

            StringBuilder sb = new StringBuilder();

            for (int r : result) {
                sb.append(r + "\n");
            }
            System.out.println(sb.toString().trim());
        }

    }
}
