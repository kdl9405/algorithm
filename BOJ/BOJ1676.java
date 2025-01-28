package boj;

import java.io.*;

/*
 * 팩토리얼 0의 개수
 */
public class BOJ1676 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        while (N >= 5) {
            count += N / 5;
            N /= 5;
        }

        System.out.println(count);

    }

}
