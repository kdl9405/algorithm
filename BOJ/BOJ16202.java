package boj;

import java.io.*;
import java.util.*;

/*
 * MST 게임
 */
public class BOJ16202 {

    static int N, M;
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        root = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }

        int[][] link = new int[M][3];

        int a, b;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            link[i] = new int[] {a, b, i + 1};
        }

        StringBuilder sb = new StringBuilder();

        int count;
        int sum;

        for (int i = 0; i < K; i++) {

            count = 1;
            sum = 0;

            for (int j = i; j < M; j++) {

                int x = findRoot(link[j][0]);
                int y = findRoot(link[j][1]);

                if (x == y) {
                    continue;
                }

                root[y] = x;
                count++;
                sum += link[j][2];

                if (count == N) {
                    break;
                }
            }

            if (count < N) {
                for (; i < K; i++) {
                    sb.append(0 + " ");
                }
                break;
            }

            sb.append(sum + " ");
            for (int j = 1; j <= N; j++) {
                root[j] = j;
            }
        }

        System.out.println(sb.toString());
    }

    static int findRoot(int i) {
        if (root[i] == i) {
            return i;
        } else {
            return root[i] = findRoot(root[i]);
        }
    }

}
