package BOJ;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 조합
 */
public class BOJ2407 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new BigInteger[n + 1][n + 1];

        System.out.println(nCr(n, m));
    }

    static BigInteger[][] arr;

    static BigInteger nCr(int n, int r) {

        if (r == 1) {
            return BigInteger.valueOf((long)n);
        }

        if (r == 0 || r == n) {
            return BigInteger.valueOf(1);
        }       

        if (arr[n][r] != null) {
            return arr[n][r];
        }

        arr[n][r] = nCr(n - 1, r - 1).add(nCr(n - 1, r));
       

        return arr[n][r];
    }
}