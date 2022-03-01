package BOJ;

/**
    최소공배수
 */

import java.io.*;
import java.util.*;

public class BOJ13241 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println((A*B)/GCD(A, B));
    }

    static long GCD(long A, long B) {

        while (A != 0) {
            long t = B % A;
            B = A;
            A = t;
        }

        return B;
    }
}