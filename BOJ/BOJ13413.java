package boj;

/*
 * 오셀로 재배치
 */

import java.io.*;

public class BOJ13413 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int black = 0;
            int white = 0;

            String from = br.readLine();
            String to = br.readLine();

            for (int i = 0; i < N; i++) {
                if (from.charAt(i) != to.charAt(i)) {
                    if (from.charAt(i) == 'B') {
                        black++;
                    } else {
                        white++;
                    }
                }
            }

            answer.append(black + white - Math.min(black, white)).append("\n");
        }

        System.out.println(answer.toString());
    }
}
