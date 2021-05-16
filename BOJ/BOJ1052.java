package BOJ;

import java.io.*;
import java.util.*;

/* 
    물병
*/
public class BOJ1052 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;

        while (n > 0) {

            if (Integer.bitCount(n) <= k) {
                break;
            }

            if (n % 2 == 1) {

                cnt += (n / 2);

            }

            n /= 2;

        }
        System.out.println(cnt);

    }
}
