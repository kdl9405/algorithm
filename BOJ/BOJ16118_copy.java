package BOJ;

import java.io.*;
import java.util.*;

/* 
    달빛 여우

    시간초과
*/
public class BOJ16118_copy {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][][] wolf = new int[n + 1][n + 1][2];
        int[][] fox = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fox[a][b] = 2 * d;
            fox[b][a] = 2 * d;
            wolf[a][b][0] = d;
            wolf[b][a][0] = d;
            wolf[a][b][1] = 4 * d;
            wolf[b][a][1] = 4 * d;

        }

        for (int k = 2; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 2; j <= n; j++) {
                    // fox
                    if (fox[i][k] != 0 && fox[k][j] != 0) {
                        if (fox[i][j] == 0) {
                            fox[i][j] = fox[i][k] + fox[k][j];
                        } else {
                            fox[i][j] = Math.min(fox[i][j], fox[i][k] + fox[k][j]);
                        }
                    }

                    // wolf
                    if (wolf[i][k][0] != 0 && wolf[k][j][1] != 0) {
                        if (wolf[i][j][1] == 0) {
                            wolf[i][j][1] = wolf[i][k][0] + wolf[k][j][1];
                        } else {
                            wolf[i][j][1] = Math.min(wolf[i][j][1], wolf[i][k][0] + wolf[k][j][1]);
                        }
                    }

                    if (wolf[i][k][1] != 0 && wolf[k][j][0] != 0) {
                        if (wolf[i][j][0] == 0) {
                            wolf[i][j][0] = wolf[i][k][1] + wolf[k][j][0];
                        } else {
                            wolf[i][j][0] = Math.min(wolf[i][j][0], wolf[i][k][1] + wolf[k][j][0]);
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (fox[1][i] < Math.min(wolf[1][i][0], wolf[1][i][1])) {
                count++;
            }
        }

        System.out.println(count);

    }
}
