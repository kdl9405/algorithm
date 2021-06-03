package BOJ;

import java.io.*;
import java.util.*;

/* 
    내려가기 

    Dp => 시간초과
*/
public class BOJ2096_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        num = new int[N][3];
        for (int i = 0; i < N; i++) {
            num[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        max = new int[N][3];
        min = new int[N][3];


        System.out.println(Math.max(findMax(N - 1, 0), Math.max(findMax(N - 1, 1), findMax(N - 1, 2))) + " "+
        Math.min(findMin(N - 1, 0), Math.min(findMin(N - 1, 1), findMin(N - 1, 2))));

    }

    static int N;
    static int[][] num;
    static int[][] max, min;

    static int findMax(int r, int c) {

        if (r == 0) {
            return num[r][c];
        }

        if (max[r][c] != 0) {
            return max[r][c];
        }

        switch (c) {
            case 0:

                max[r][c] = Math.max(findMax(r - 1, 0), findMax(r - 1, 1));
                break;

            case 1:

                max[r][c] = Math.max(findMax(r - 1, 0), Math.max(findMax(r - 1, 1), findMax(r - 1, 2)));
                break;
            case 2:

                max[r][c] = Math.max(findMax(r - 1, 1), findMax(r - 1, 2));
                break;
        }

        return max[r][c] = max[r][c] + num[r][c];
    }

    static int findMin(int r, int c) {

        if (r == 0) {
            return num[r][c];
        }

        if (min[r][c] != 0) {
            return min[r][c];
        }

        switch (c) {
            case 0:

                min[r][c] = Math.min(findMin(r - 1, 0), findMin(r - 1, 1));
                break;

            case 1:

                min[r][c] = Math.min(findMin(r - 1, 0), Math.min(findMin(r - 1, 1), findMin(r - 1, 2)));
                break;
            case 2:

                min[r][c] = Math.min(findMin(r - 1, 1), findMin(r - 1, 2));
                break;
        }

        return min[r][c] = min[r][c] + num[r][c];
    }
}
