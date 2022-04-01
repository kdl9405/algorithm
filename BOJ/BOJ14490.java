package BOJ;

/* 
    백대열
*/

import java.io.*;
import java.util.*;

public class BOJ14490 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":", false);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int gcd = (n < m) ? getGCD(n, m) : getGCD(m, n);

        StringBuilder sb = new StringBuilder();
        sb.append(n/gcd).append(":").append(m/gcd);
        System.out.println(sb.toString());

    }

    static int getGCD(int n, int m) {

        while (n != 0) {
            int t = m % n;
            m = n;
            n = t;
        }

        return m;
    }
}
