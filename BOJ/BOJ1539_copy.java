package boj;

/*
 * 중량제한
 */

import java.io.*;
import java.util.*;

public class BOJ1539_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        bridge = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            bridge.add(new ArrayList<>());
        }

        int max = 0;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            bridge.get(A).add(new int[] {B, C});
            bridge.get(B).add(new int[] {A, C});

            max = Math.max(max, C);

        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        visit[from] = true;
        answer = 0;

        findRoute(from, to, max);

        System.out.println(answer);

    }

    static List<List<int[]>> bridge;
    static boolean[] visit;
    static int answer;

    static void findRoute(int now, int to, int weight) {

        if (weight < answer) {
            return;
        }

        if (to == now) {
            answer = Math.max(answer, weight);
            return;
        }

        for (int[] next : bridge.get(now)) {
            if (visit[next[0]] || next[1] < answer) {
                continue;
            }
            visit[next[0]] = true;
            findRoute(next[0], to, Math.min(weight, next[1]));
            visit[next[0]] = false;

        }
    }
}
