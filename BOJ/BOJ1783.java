package BOJ;

/**
병든 나이트
 */

import java.io.*;
import java.util.*;

public class BOJ1783 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max = 0;
        if (N == 1) {
            max = 1;
        } else if (N == 2) {
            max = Math.min(4, (M - 1) / 2 + 1);
        } else if (M <= 6) {
            max = Math.min(4, M);
        } else {
            max = M - 2;
        }

        System.out.println(max);
    }

}