package BOJ;

/* 
    성적 통계
*/

import java.io.*;
import java.util.*;

public class BOJ5800 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();

        StringTokenizer st;
        int classNum = 0;
        while (classNum++ < K) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[] scores = new int[N];
            for (int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(scores);

            answer.append("Class ").append(classNum).append("\n");
            answer.append("Max ").append(scores[N - 1]).append(", Min, ").append(scores[0]);

            int gap = 0;
            for (int i = 0; i < N - 1; i++) {
                gap = Math.max(gap, scores[i + 1] - scores[i]);
            }

            answer.append(", Largest gap ").append(gap).append("\n");
        }

        System.out.println(answer.toString());
    }
}
