package boj;

/*
 * 회문은 회문아니야!!
 * 
 * 1. 입력 S가 펠린드롬이 아니면 -> S의 길이 2. 펠린드롬이라면 3. 하나의 문자열로 이루어져 있다면? -> -1 리턴 4. 아니라면 -> S의 길이 -1
 * 
 */

import java.io.*;
import java.util.HashSet;

public class BOJ15927 {

    public static void main(String[] args) throws IOException {

        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();


        boolean check = true;
        boolean one = true;

        for (int i = 0; i < S.length() / 2; i++) {

            if (S.charAt(i) != S.charAt(i + 1)) {
                one = false;
            }

            if (S.charAt(i) != S.charAt(S.length() - 1 - i)) {
                check = false;
                break;
            }

        }

        if (!check) {
            answer = S.length();
        } else if (one) {
            answer = -1;
        } else {
            answer = S.length() - 1;
        }

        System.out.println(answer);

    }
}
