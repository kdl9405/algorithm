package BOJ;

/* 
    올림픽 
*/

import java.io.*;
import java.util.*;

public class BOJ8979 {

    public static void main(String[] args) throws IOException {

        new BOJ8979().solution();
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
            olympics[i][3] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(olympics, (a, b) -> {
            if (a[1] == b[1]) {
                if (a[2] == b[2]) {

                    if (a[3] == b[3]) {
                        int x = a[0] == K ? -1 : 1;
                        int y = b[0] == K ? -1 : 1;

                        return x - y;
                    }
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
