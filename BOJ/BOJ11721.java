package boj;

/**
 * 열 개씩 끊어 출력하기
 */

import java.io.*;

public class BOJ11721 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if ((i + 1) % 10 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
