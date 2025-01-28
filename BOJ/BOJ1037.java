package boj;

/*
 * 약수
 */

import java.io.*;
import java.util.*;

public class BOJ1037 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        if (num.length % 2 == 1) {
            System.out.println(num[num.length / 2] * num[num.length / 2]);
        } else {

            System.out.println(num[0] * num[num.length - 1]);

        }

    }

}
