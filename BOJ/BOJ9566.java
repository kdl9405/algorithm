package boj;

/*
 * 돌 게임 2
 */

import java.io.*;

public class BOJ9566 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N % 2 == 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
