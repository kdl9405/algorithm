package boj;

import java.io.*;

/*
 * 막대기
 * 
 * x 를 2진수로 표현했을 때의 1의 개수
 */

public class BOJ1094_copy2 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        String stick = Integer.toBinaryString(x).replaceAll("0", "");

        System.out.println(stick.length());

    }
}
