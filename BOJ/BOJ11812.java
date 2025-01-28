package boj;


/*
 * K진 트리
 */

import java.io.*;
import java.util.*;

public class BOJ11812 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            if (K == 1) {
                sb.append(Math.abs(x - y)).append("\n");
            } else {

                int d = 0;

                while (x != y) {
                    if (x > y) {
                        x = (x + K - 2) / K;
                    } else {
                        y = (y + K - 2) / K;
                    }

                    d++;
                }

                sb.append(d).append("\n");
            }
        }

        System.out.println(sb.toString().trim());


    }
}
