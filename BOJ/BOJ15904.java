package boj;

import java.io.*;

/*
 * UCPC는 무엇의 약자일까?
 */
public class BOJ15904 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String answer = "I hate UCPC";

        char[] S = br.readLine().toCharArray();

        char[] UCPC = {'U', 'C', 'P', 'C'};

        int index = 0;
        for (int i = 0; i < S.length; i++) {

            if (S[i] == UCPC[index]) {
                index++;
            }

            if (index == 4) {
                answer = "I love UCPC";
                break;
            }
        }

        System.out.println(answer);

    }

}
