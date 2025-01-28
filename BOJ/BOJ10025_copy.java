package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 게으른 백곰
 * 
 * java 11 : 544ms
 */

public class BOJ10025_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] ice = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ice[i][0] = Integer.parseInt(st.nextToken()); // g
            ice[i][1] = Integer.parseInt(st.nextToken()); // x
        }

        Arrays.sort(ice, (a, b) -> {
            return a[1] - b[1];
        });

        long max = 0;

        if (ice[N - 1][1] - ice[0][1] <= K * 2) {
            for (int[] i : ice) {
                max += i[0];
            }

            System.out.println(max);
        } else {

            int from = 0;
            int to = 0;
            int sum = 0;
            for (; to < N; to++) {
                if (ice[to][1] > ice[0][1] + (K * 2)) {
                    break;
                }
                sum += ice[to][0];
            }

            max = sum;

            for (; to < N; to++) {
                sum += ice[to][0];

                while (ice[from][1] < ice[to][1] - (K * 2)) {
                    sum -= ice[from][0];
                    from++;
                }

                max = Math.max(max, sum);
            }

            System.out.println(max);
        }

    }
}
