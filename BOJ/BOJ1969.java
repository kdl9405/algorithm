package BOJ;

/* 
    DNA 
*/

import java.io.*;
import java.util.*;

public class BOJ1969 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] alphabet = new int[M][26];

        for (int i = 0; i < N; i++) {
            String DNA = br.readLine();
            for (int j = 0; j < M; j++) {
                alphabet[j][DNA.charAt(j) - 'A']++;
            }
        }

        StringBuilder answer = new StringBuilder();
        int sum = 0;

        for (int i = 0; i < M; i++) {

            char alp = ' ';
            int cnt = 0;
            for (int j = 0; j < 26; j++) {
                if (alphabet[i][j] > cnt) {
                    cnt = alphabet[i][j];
                    alp = (char)('A'+j);
                }
            }

            answer.append(alp);
            sum +=(N-cnt);
        }

        answer.append("\n").append(sum);
        System.out.println(answer.toString());
    }
}
