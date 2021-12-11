package BOJ;

/* 
    0의 개수
*/

import java.io.*;
import java.util.*;

public class BOJ11170 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] count = new int[1000001];
        count[0] = 1;

        // for (int i = 1; i <= 1000000; i++) {

        // count[i] = count[i-1] + String.valueOf(i).replaceAll("[^0]", "").length();

        // }

        int zero = 0;

        for (int i = 1; i <= 1000000; i++) {
            zero = 0;
            for (int j = i; j > 0; j /= 10)
                if (j % 10 == 0) {
                    zero++;
                }
            count[i] = count[i - 1] + zero;
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0) {
                sb.append(count[M] + "\n");
            } else {
                sb.append((count[M] - count[N - 1]) + "\n");

            }

        }

        System.out.println(sb.toString().trim());

    }

}
