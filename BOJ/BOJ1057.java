
package BOJ;

/**
 * 토너먼트
 */

import java.io.*;
import java.util.*;

public class BOJ1057 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int round = 0;

        while (a != b) {

            round++;

            a = (a + 1) / 2;
            b = (b + 1) / 2;

        }

        System.out.println(round);
    }

}
