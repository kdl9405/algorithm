package boj;

import java.io.*;

/*
 * 막대기
 * 
 * x 를 2진수로 표현했을 때의 1의 개수
 */

public class BOJ1094 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int count = 0;

        while (x > 0) {
            if (x % 2 == 1) {
                count++;
            }
            x /= 2;
        }

        System.out.println(count);
    }
}
