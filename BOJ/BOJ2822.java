package BOJ;

import java.io.*;
import java.util.*;

/* 
    점수 계산
*/
public class BOJ2822 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ2822().solution();

    }

    private void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] scores = new int[8][2];
        for (int i = 0; i < 8; i++) {
            scores[i][0] = i + 1;
            scores[i][1] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(scores, (a, b) -> {
            return b[1] - a[1];
        });

        Arrays.sort(scores, 0, 5, (a, b) -> {
            return a[0] - b[0];
        });

        int sum = 0;
        StringBuilder question = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sum += scores[i][1];
            question.append(scores[i][0]).append(" ");
        }   

        System.out.println(sum);
        System.out.println(question.toString().trim());

    }
}
