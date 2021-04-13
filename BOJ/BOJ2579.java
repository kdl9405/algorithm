package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {

    static int[] stair;
    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        stair = new int[n + 1];
        arr = new int[n + 1];

        stair[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(dp(n));

    }

    static int dp(int d) {

        if (d == 0) {
            return 0;
        }
        if (d == 1) {
            return stair[1];
        }
        if (d == 2) {
            return stair[1] + stair[2];
        }

        if (arr[d] == 0) {
            arr[d] = Math.max(dp(d - 2), dp(d - 3) + stair[d - 1]) + stair[d];
        }

        return arr[d];
       
    }
}
