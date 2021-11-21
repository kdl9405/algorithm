package BOJ;

/*
    음악프로그램 


    메모리초과!!
*/

import java.io.*;
import java.util.*;

public class BOJ2623_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        beforeNums = new HashMap<>();
        afterNums = new HashMap<>();
        level = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            beforeNums.put(i, new HashSet<>());
            afterNums.put(i, new HashSet<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());

            int before = Integer.parseInt(st.nextToken());

            while (c-- > 1) {
                int after = Integer.parseInt(st.nextToken());

                beforeNums.get(after).add(before);
                afterNums.get(before).add(after);
                level[after] = Math.max(level[after], level[before] + 1);
                before = after;

            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return level[a] - level[b];
        });

        for (int i = 1; i <= N; i++) {
            if (level[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        visit = new boolean[N + 1];
        while (!pq.isEmpty()) {

            int now = pq.poll();

            if (level[now] > N) {
                sb = new StringBuilder();
                sb.append(0);
                break;
            }

            int min = -1;

            for (int b : beforeNums.get(now)) {

                min = Math.max(min, level[b]);

                if (!visit[b]) {
                    pq.add(b);
                }
            }

            if (min >= level[now]) {
                level[now]++;
                pq.add(now);
            } else {
                if (!visit[now]) {
                    visit[now] = true;
                    sb.append(now + "\n");
                }
            }

            for (int a : afterNums.get(now)) {
                if (level[a] <= level[now]) {
                    level[a] = level[now] + 1;
                }
                pq.add(a);
            }

        }

        System.out.println(sb.toString().trim());
    }

    static int N, M;
    static HashMap<Integer, HashSet<Integer>> beforeNums;
    static HashMap<Integer, HashSet<Integer>> afterNums;
    static int[] level;
    static boolean[] visit;

}
