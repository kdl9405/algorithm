package BOJ;

/* 
    뒤집기
*/

import java.io.*;

public class BOJ1439 {

    public static void main(String[] args) throws IOException {

        new BOJ1439().solution();
    }

    private void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int count = 0;
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) != S.charAt(i + 1)) {
                count++;
            }
        }

        int answer = (count / 2);
        if (count % 2 == 1) {
            answer++;
        }
        System.out.println(answer);

    }
}
