package boj;

import java.io.*;
import java.util.*;


/**
 * 2007년
 */
public class BOJ1924 {

    public static void main(String[] args) throws IOException {

        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        while (x-- > 0) {

            y += month[x];

        }

        System.out.println(day[y % 7]);

    }
}
