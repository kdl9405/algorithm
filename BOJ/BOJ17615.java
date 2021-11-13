package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
    볼 모으기

    개선 핖요
*/
public class BOJ17615 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String ball = br.readLine();

        int answer = Integer.MAX_VALUE;

        String moveRed = ball.replaceAll("B+", "B");

        int c = 0;
        boolean m = false;

        for (int i = 0; i < moveRed.length(); i++) {
            if (moveRed.charAt(i) == 'R') {
                if (m) {
                    c++;
                }
            } else {
                m = true;
            }
        }

        answer = Math.min(answer, c);

        c = 0;
        m = false;

        for (int i = moveRed.length() - 1; i >= 0; i--) {
            if (moveRed.charAt(i) == 'R') {
                if (m) {
                    c++;
                }
            } else {
                m = true;
            }
        }

        answer = Math.min(answer, c);

        String moveBlue = ball.replaceAll("R+", "R");

        c = 0;
        m = false;

        for (int i = 0; i < moveBlue.length(); i++) {
            if (moveBlue.charAt(i) == 'B') {
                if (m) {
                    c++;
                }
            } else {
                m = true;
            }
        }

        answer = Math.min(answer, c);

        c = 0;
        m = false;

        for (int i = moveBlue.length() - 1; i >= 0; i--) {
            if (moveBlue.charAt(i) == 'B') {
                if (m) {
                    c++;
                }
            } else {
                m = true;
            }
        }

        answer = Math.min(answer, c);

        System.out.println(answer);

    }
}
