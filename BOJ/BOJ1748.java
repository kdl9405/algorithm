package boj;

/**
 * 수 이어 쓰기 1
 */

import java.io.*;

public class BOJ1748 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ1748().solution();
    }

    private void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int digit = 1;
        int range = 10;
        for (int i = 1; i <= N; i++) {
            if (i % range == 0) {
                digit++;
                range *= 10;
            }
            answer += digit;
        }

        System.out.println(answer);
    }

}
