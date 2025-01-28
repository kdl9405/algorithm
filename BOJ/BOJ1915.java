package boj;

import java.io.*;
import java.util.*;

/*
 * 가장 큰 정사각형
 */
public class BOJ1915 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][m + 1];
        int size = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i + 1][j + 1] = line.charAt(j) - '0';

                if (line.charAt(j) != '0') {
                    arr[i + 1][j + 1] =
                            Math.min(Math.min(arr[i][j], arr[i][j + 1]), arr[i + 1][j]) + 1;
                    size = Math.max(size, arr[i + 1][j + 1]);
                }
            }
        }


        System.out.println(size * size);
    }


}


