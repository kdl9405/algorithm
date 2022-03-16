package BOJ;

/**
 * 팰린드롬 만들기
 */

import java.io.*;

public class BOJ1254 {

    public static void main(String[] args) throws IOException {

        new BOJ1254().solution();
    }

    void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int answer = S.length();
        for (int i = 0; i < S.length(); i++) {

            if (isFin(S.substring(i))) {
                break;
            }
            answer++;
        }

        System.out.println(answer);

    }

    boolean isFin(String s) {

        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

}