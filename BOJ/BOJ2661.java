package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
    좋은수열
*/
public class BOJ2661 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        int N = input();

        new BOJ2661().solution(N);
    }

    static int input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return Integer.parseInt(br.readLine());
    }

    void solution(int N) {

        answer = "";

        isFind = false;

        dfs(new StringBuilder(1), N);

        System.out.println(answer);

    }

    boolean isFind;
    String answer;

    void dfs(StringBuilder sb, int N) {

        if (isFind) {
            return;
        }

        if (sb.length() == N) {

            isFind = true;
            answer = sb.toString();

            return;
        }

        String s = sb.toString();
        for (int i = 1; i <= 3; i++) {

            if (!isNegative(s + i)) {
                dfs(new StringBuilder(s).append(i), N);
            }
        }
    }

    boolean isNegative(String s) {

        for (int i = 1; i <= s.length() / 2; i++) {

            if (s.substring(s.length() - i, s.length())
                    .equals(s.substring(s.length() - i - i, s.length() - i))) {

                return true;
            }
        }

        return false;
    }

}
