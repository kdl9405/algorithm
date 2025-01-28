package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 신입사원
 */
public class BOJ1946 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());

            }

            Arrays.sort(arr, (a, b) -> {
                return a[0] - b[0];
            });

            int c = 1;

            int b = arr[0][1];
            for (int i = 1; i < N; i++) {

                if (b > arr[i][1]) {
                    c++;
                    b = arr[i][1];
                }

            }
            sb.append(c + "\n");

        }

        System.out.println(sb.toString().trim());
    }
}
