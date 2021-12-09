package BOJ;

/* 
    약수의 합

*/

import java.io.*;
import java.util.*;

public class BOJ17425 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] fx = new long[1000001];
        long[] gx = new long[1000001];

        Arrays.fill(fx, 1L);
        for (int i = 2; i < 1000001; i++) {
            for (int j = 1; i * j < 1000001; j++) {
                fx[i * j] += i;
            }
        }

        for (int i = 1; i < 1000001; i++) {
            gx[i] = gx[i - 1] + fx[i];
        }

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            sb.append(gx[n]+"\n");
            
        }

        br.close();

        System.out.println(sb.toString().trim());

    }

}
