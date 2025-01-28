package boj;

/*
 * 선 긋기
 */

import java.io.*;
import java.util.*;

public class BOJ2170 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] line = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int x = -1000000000;
        int y = -1000000000;

        int length = 0;
        for (int[] l : line) {
            if (l[0] > y) {
                length += (y - x);
                x = l[0];
                y = l[1];
            } else if (l[1] > y) {
                y = l[1];
            }
        }

        length += (y - x);

        System.out.println(length);

    }
}
