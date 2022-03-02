package BOJ;

/**
수열
*/

import java.io.*;
import java.util.*;

public class BOJ2491 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int maxCount = 1;

        int increseCnt = 1;
        int decreseCnt = 1;
        for (int i = 1; i < N; i++) {
            if (num[i] <= num[i - 1]) {
                increseCnt++;
                maxCount = Math.max(increseCnt, maxCount);
            } else {
                increseCnt = 1;
            }

            if (num[i] >= num[i - 1]) {
                decreseCnt++;
                maxCount = Math.max(decreseCnt, maxCount);
            } else {
                decreseCnt = 1;
            }

        }

        System.out.println(maxCount);
    }

}