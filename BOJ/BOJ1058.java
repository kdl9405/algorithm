package BOJ;

/**
    친구
*/

import java.io.*;

public class BOJ1058 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] friends = new int[N][N];

        for (int i = 0; i < N; i++) {

            char[] friendship = br.readLine().toCharArray();

            for (int j = 0; j < N; j++) {
                if (friendship[j] == 'Y') {
                    friends[i][j] = 2;
                    friends[j][i] = 2;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {

                if (i == k) {
                    continue;
                }

                for (int j = 0; j < N; j++) {
                    if (j == i || j == k) {
                        continue;
                    }

                    if (friends[i][j] == 0 && friends[i][k] == 2 && friends[k][j] == 2) {
                        friends[i][j] = 1;
                        friends[j][i] = 1;
                    }

                }
            }
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {

                if (friends[i][j]>=1) {
                    count++;
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);

    }
}