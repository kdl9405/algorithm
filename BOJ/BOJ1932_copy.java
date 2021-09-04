package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
    재채점??
*/

public class BOJ1932_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(br.readLine());
            System.out.close();
        }

        int[][] arr = new int[n][n];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            arr[i][0] += arr[i - 1][0];
            arr[i][i] += arr[i - 1][i - 1];
        }

        if (n > 2) {
            for (int i = 2; i < n; i++) {
                for (int j = 1; j < i; j++) {
                    arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
                }
            }
        }

        int max = arr[n - 1][0];

        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[n - 1][i]);
        }
        
        System.out.println(max);

    }
}
