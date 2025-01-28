package boj;

import java.io.*;
import java.util.StringTokenizer;

/*
 * 타일 위의 대각선
 */
public class BOJ2168 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int g = GCD(x, y);

        System.out.println((x + y) - g);

    }

    static int GCD(int x, int y) {

        if (x < y) {
            int t = x;
            x = y;
            y = t;
        }

        while (y != 0) {
            int t = x % y;
            x = y;
            y = t;
        }

        return x;
    }
}
