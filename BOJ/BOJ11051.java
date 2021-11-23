package BOJ;

/* 
    이항 계수 2
*/
import java.io.*;
import java.util.*;

public class BOJ11051 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];

        System.out.println(nCr(n, k));

    }

    static int[][] arr;

    static int nCr(int n, int c) {

        if (c == 0 || n == c) {
            return 1;
        }

        if (arr[n][c] != 0) {
            return arr[n][c];
        }

        return arr[n][c] = (nCr(n - 1, c) + nCr(n - 1, c - 1)) % 10007;
    }
}
