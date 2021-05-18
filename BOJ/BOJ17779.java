package BOJ;

import java.io.*;
import java.util.*;

/* 
    게리맨더링 2
*/
public class BOJ17779 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        total = 0;
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        int Min = Integer.MAX_VALUE;

        for (int x = 0; x + 2 < N; x++) {
            for (int y = 0; y + 2 < N; y++) {
                for (int d1 = 1;; d1++) {
                    if (y-d1 < 0) {
                        break;
                    }
                    for (int d2 = 1;; d2++) {
                        
                        if (x+d2>=N || y+d2>=N || x+d1+d2 >= N) {
                            break;
                        }

                        Min = Math.min(Min, findDiff(x, y, d1, d2));
                    }
                }
            }
        }

        System.out.println(Min);

    }

    static int N, total;
    static int[][] map;

    static int findDiff(int x, int y, int d1, int d2) {

        boolean[][] line = new boolean[N][N];

        for (int i = 0; i <= d1; i++) {
            line[x + i][y - i] = true;
            line[x + d2 + i][y + d2 - i] = true;
        }

        for (int i = 0; i <= d2; i++) {
            line[x + i][y + i] = true;
            line[x + d1 + i][y - d1 + i] = true;
        }

        int[] count = new int[5];

        // 1
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (line[i][j])
                    break;
                count[0] += map[i][j];
            }
        }

        // 2
        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if (line[i][j])
                    break;
                count[1] += map[i][j];
            }
        }

        // 3
        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (line[i][j])
                    break;
                count[2] += map[i][j];
            }
        }

        // 4
        for (int i = x + d2 + 1; i < N; i++) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (line[i][j])
                    break;
                count[3] += map[i][j];
            }
        }

        count[4] = total;
        for (int i = 0; i < 4; i++) {
            count[4] -= count[i];
        }

        Arrays.sort(count);

        return count[4] - count[0];

    }
}
