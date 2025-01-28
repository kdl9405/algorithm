package boj;

import java.io.*;
import java.util.*;

public class BOJ30802 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        int[] needsCount =
                Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int tShirts = 0;
        for (int count : needsCount) {
            if (count % T != 0) {
                tShirts++;
            }
            tShirts += count / T;
        }

        int penSet = total / P;
        int pneCnt = total % P;

        System.out.println(tShirts);
        System.out.println(penSet + " " + pneCnt);

    }
}
