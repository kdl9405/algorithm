package BOJ;

/* 
    수열의 합
*/

import java.io.*;
import java.util.*;

public class BOJ1024 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int extra = 0;
        for (int i = 1; i < L; i++) {
            extra += i;
        }

        while (L <= 100 && N >= extra) {

            if ((N - extra) % L == 0) {

                N = (N - extra) / L;
                StringBuilder answer = new StringBuilder();
                for (int i = 0; i < L; i++) {
                    answer.append(N++).append(" ");
                }
                System.out.println(answer.toString().trim());

                return;
            }

            extra += L;
            L++;
        }

        System.out.println(-1);
    }

}
