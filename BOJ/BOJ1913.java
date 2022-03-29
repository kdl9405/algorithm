package BOJ;

/*
    달팽이
 */

import java.io.*;

public class BOJ1913 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        int x = N / 2;
        int y = N / 2;

        int index = 1;

        int c = 1;
        int d = 0;

        int[] point = new int[2];

        while (index < N * N) {

            for (int i = 0; i < c; i++) {
                if (index == target) {
                    point[0] = x + 1;
                    point[1] = y + 1;
                }

                arr[x][y] = index++;
                x += dir[d][0];
                y += dir[d][1];
            }

            d = (d + 1) % 4;

            if (d % 2 == 0) {
                c++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(point[0]).append(" ").append(point[1]);

        System.out.println(sb.toString().trim());

    }

    static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

}