package BOJ;

/* 
    좋은수열
*/

import java.io.*;

public class BOJ2661_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ2661_copy().soluion();
    }

    void soluion() throws NumberFormatException, IOException {

        input();

        dfs(1, "1");

        System.out.println(answer);

    }

    int N;
    String answer = "";
    boolean isFind = false;

    void input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    void dfs(int len, String s) {

        for (int i = 1; i <= (len) / 2; i++) {
            if (s.substring(len - i, len).equals(s.substring(len - 2 * i, len - i)))
                return;
        }

        if (len == N) {
            answer = s;
            isFind = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            dfs(len + 1, s + i);
            if (isFind)
                return;
        }
    }
}
