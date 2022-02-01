package BOJ;

/**

기타리스트

*/

import java.io.*;
import java.util.*;

public class BOJ1495 {

    public static void main(String[] args) throws IOException {

        new BOJ1495().solution();
    }

    void solution() throws IOException {

        init();

        int answer = BFS();

        System.out.println(answer);

    }

    int N, S, M;
    int[] V;

    void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        V = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        // dp = new int[2][N + 1];
        // Arrays.fill(dp[0], -2);
        // Arrays.fill(dp[1], -2);

        // dp[0][0] = S;
        // dp[1][0] = S;

    }

    int BFS() {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);

        for (int i = 1; i <= N; i++) {

            if (queue.isEmpty()) {
                return -1;
            }

            int size = queue.size();
            Set<Integer> volume = new HashSet<>();
            while (size-- > 0) {
                int P = queue.poll();
                int a = P + V[i];
                if (a <= M && a >= 0) {
                    volume.add(a);
                }
                a = P - V[i];
                if (a <= M && a >= 0) {
                    volume.add(a);
                }
            }

            queue.addAll(volume);
        }

        int lastV = -1;
        while (!queue.isEmpty()) {
            lastV = Math.max(lastV, queue.poll());
        }
        return lastV;
    }

    // int findDP(int s, int i) {

    // if (dp[s][i] != -2) {
    // return dp[s][i];
    // }

    // int a = findDP(0, i - 1);
    // int b = findDP(1, i - 1);

    // if (a != -1) {
    // a = getVolume(a, s, i);
    // }

    // if (b != -1) {
    // b = getVolume(b, s, i);
    // }

    // if ((a < 0 || a > M) && (b < 0 || b > M)) {
    // return dp[s][i] = -1;
    // }

    // if ((a < 0 || a > M)) {
    // return dp[s][i] = b;
    // }

    // if (b < 0 || b > M) {
    // return dp[s][i] = a;
    // }

    // return dp[s][i] = Math.max(a, b);
    // }

    // int getVolume(int P, int s, int i) {

    // if (s == 0) {
    // P -= V[i];
    // } else {
    // P += V[i];
    // }

    // if (P < 0 || P > M) {
    // return -1;
    // }

    // return P;
    // }

}