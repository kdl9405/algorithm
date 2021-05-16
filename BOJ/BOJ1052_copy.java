package BOJ;

import java.io.*;
import java.util.*;

/* 
    물병

    시간초과.
*/
public class BOJ1052_copy {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int x = 0;

        while (Integer.bitCount(n) > k) {

            while (true) {
                if ((n & (1 << x)) != 0) {

                    int b = (int) Math.pow(2, x);
                    n += b;
                    cnt += b;
                    break;
                }

                x++;
            }
        }
        System.out.println(cnt);

    }
}
