package boj;

import java.io.*;
import java.util.*;

/*
 * 주사위 세개
 */
public class BOJ2480 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] number = new int[3];
        for (int i = 0; i < 3; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        if (number[0] == number[1] && number[1] == number[2]) {
            answer = 10000 + number[0] * 1000;
        } else if (number[0] == number[1] || number[1] == number[2]) {
            answer = 1000 + number[1] * 100;
        } else if (number[0] == number[2]) {
            answer = 1000 + number[0] * 100;
        } else {
            answer = Math.max(number[0], Math.max(number[1], number[2])) * 100;
        }

        System.out.println(answer);

    }

}
