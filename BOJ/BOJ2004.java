package BOJ;

import java.io.*;
import java.util.*;

/* 
    조합 0의 개수

*/

public class BOJ2004 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long two = findTwo(n) - findTwo(n-m) - findTwo(m);
        long five = findFive(n) - findFive(n-m) - findFive(m);

        System.out.println(Math.min(two, five));

    }

    static long findTwo(long num) {

        long count = 0;

        while (num >= 2) {

            count += (num / 2);

            num /= 2;
        }

        return count;

    }

    static long findFive(long num) {

        long count = 0;

        while (num >= 5) {

            count += (num / 5);

            num /= 5;
        }

        return count;

    }

}
