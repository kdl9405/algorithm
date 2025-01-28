package boj;

/*
 * 날짜 계산
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ1476 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e, s, m;
        int year = 1;
        while (true) {

            e = (year % 15 == 0 ? 15 : year % 15);
            s = (year % 28 == 0 ? 28 : year % 28);
            m = (year % 19 == 0 ? 19 : year % 19);

            if (E == e && S == s && M == m) {
                break;
            }
            year++;
        }

        System.out.println(year);

    }
}
