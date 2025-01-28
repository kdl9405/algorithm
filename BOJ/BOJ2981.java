package boj;

/*
 * 검문
 */

import java.io.*;
import java.util.*;

public class BOJ2981 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);

        int x = num[1] - num[0];

        for (int i = 2; i < N; i++) {
            x = gcd(x, num[i] - num[i - 1]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(x); i++) {

            if (i * i == x) {
                list.add(i);
            } else if (x % i == 0) {
                list.add(i);
                list.add((x / i));
            }

        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (int a : list) {
            sb.append(a + " ");
        }
        sb.append(x);

        System.out.println(sb.toString().trim());

    }

    static int gcd(int a, int b) {

        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
