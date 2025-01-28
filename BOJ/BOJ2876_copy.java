package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2876_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][6];

        int count = 0;
        int grade = 0;

        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][a] = arr[i - 1][a] + 1;

            if (arr[i][a] > count) {
                count = arr[i][a];
                grade = a;
            }

            if (a != b) {
                arr[i][b] = arr[i - 1][b] + 1;
                if (arr[i][b] > count) {
                    count = arr[i][b];
                    grade = b;
                }

            }

        }

        System.out.println(count + " " + grade);
    }
}
