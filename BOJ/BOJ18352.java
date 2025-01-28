package boj;

/*
 * 특정 거리의 도시 찾기
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ18352 {

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

        Queue<Integer> queue = new LinkedList<>();

        queue.add(X);
        boolean[] visit = new boolean[N + 1];
        visit[X] = true;

        int d = 0;

        while (d < K) {

            int size = queue.size();

            d++;
            while (size-- > 0) {
                int now = queue.poll();

                for (int next : roads.get(now)) {
                    if (visit[next]) {
                        continue;
                    }
                    visit[next] = true;
                    queue.add(next);
                }
            }

        }

        if (queue.isEmpty()) {
            System.out.println(-1);
        } else {

            List<Integer> list = new ArrayList<>(queue);

            Collections.sort(list);

            StringBuilder sb = new StringBuilder();

            for (int n : list) {
                sb.append(n + "\n");
            }
            System.out.println(sb.toString().trim());
        }

    }
}
