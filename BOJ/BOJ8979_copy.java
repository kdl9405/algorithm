package BOJ;

/* 
    올림픽 
*/

import java.io.*;
import java.util.*;

public class BOJ8979_copy {

    public static void main(String[] args) throws IOException {

        new BOJ8979_copy().solution();
    }

    private void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] olympics = new int[N][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            olympics[i][0] = Integer.parseInt(st.nextToken());
            olympics[i][1] = Integer.parseInt(st.nextToken());
            olympics[i][2] = Integer.parseInt(st.nextToken());
            olympics[i][3] = Integer.parseInt(st.nextToken()) * 2;
            if (olympics[i][0] == K) {
                olympics[i][3]++;
            }
        }

        Arrays.sort(olympics, (a, b) -> {
            if (a[1] == b[1]) {
                if (a[2] == b[2]) {

                    return b[3] - a[3];
                }
                return b[2] - a[2];
            }
            return b[1] - a[1];
        });

        for (int i = 0; i < N; i++) {

            if (olympics[i][0] == K) {
                System.out.println(i + 1);
                break;
            }
        }

    }

}
