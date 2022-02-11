package BOJ;

/* 
    최대공약수
 */

import java.io.*;
import java.util.*;

public class BOJ1850 {

    public static void main(String[] args) throws IOException {

        new BOJ1850().solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long gcd = (A < B) ? GCD(A, B) : GCD(B, A);

        System.out.println("1".repeat((int)gcd));
    }

    long GCD(long A, long B) {

        while (A != 0) {
            long temp = B % A;
            B = A;
            A = temp;
        }

        return B;
    }

}
