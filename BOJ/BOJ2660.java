package boj;

/*
 * 회장뽑기
 */

import java.io.*;
import java.util.*;

public class BOJ2660 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        friendship = new int[N + 1][N + 1];

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) {
                break;
            }

            friendship[a][b] = 1;
            friendship[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (k == i) {
                    continue;
                }
                for (int j = 1; j <= N; j++) {
                    if (k == j || i == j || friendship[i][k] == 0 || friendship[k][j] == 0) {
                        continue;
                    }

                    if (friendship[i][j] == 0
                            || friendship[i][j] > friendship[i][k] + friendship[k][j]) {
                        friendship[i][j] = friendship[i][k] + friendship[k][j];
                        friendship[j][i] = friendship[i][j];
                    }
                }
            }
        }

        int point = Integer.MAX_VALUE;

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int j = 1; j <= N; j++) {
                max = Math.max(max, friendship[i][j]);
            }

            if (point > max) {
                point = max;
                list = new ArrayList<>();
                list.add(i);
            } else if (point == max) {
                list.add(i);
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(point).append(" ").append(list.size()).append("\n");
        for (Integer i : list) {
            answer.append(i).append(" ");
        }

        System.out.println(answer.toString());

    }

    static int N;
    static int[][] friendship;

}
