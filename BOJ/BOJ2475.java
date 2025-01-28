package boj;

import java.io.*;
import java.util.*;

/*
 * 검증수
 */

public class BOJ2475 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = 0;
        for (int i = 0; i < 5; i++) {
            int x = Integer.parseInt(st.nextToken());

            total += (x * x);
        }

        int answer = total %= 10;

        System.out.println(answer);
    }
}
