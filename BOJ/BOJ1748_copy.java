package boj;

/**
 * 수 이어 쓰기 1
 */

import java.io.*;

public class BOJ1748_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ1748_copy().solution();
    }

    private void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 1;
        int digit = 1;
        int range = 10;
        for (int i = 1; i <= N; i++) {

            if (N >= range) {
                answer += ((range - (range / 10)) * digit) + 1;
                i = range - 1;
                digit++;
                range *= 10;
            } else {
                answer += ((N - (range / 10)) * digit);
                break;
            }
        }

        System.out.println(answer);
    }

}
