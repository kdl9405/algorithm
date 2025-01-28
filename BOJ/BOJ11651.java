package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ11651
 */
public class BOJ11651 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] position = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            position[i][0] = Integer.parseInt(st.nextToken());
            position[i][1] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(position, (p1, p2) -> {

            if (p1[1] == p2[1]) {
                return p1[0] - p2[0];
            } else {
                return p1[1] - p2[1];
            }

        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(position[i][0] + " " + position[i][1]).append("\n");
        }

        System.out.println(sb);

    }
}
