package BOJ;

import java.io.*;
import java.util.*;

/* 
    색종이 붙이기
*/
public class BOJ17136 {

    public static void main(String[] args) throws IOException {

        new BOJ17136().solution();
    }

    void solution() throws IOException {

        init();

        backTracking(0, 0, 0);

        System.out.println(answer != 26 ? answer : -1);

    }

    int[][] paper;
    int[] colorPaper;
    int answer = 26;

    void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        paper = new int[10][10];

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        colorPaper = new int[6];
        Arrays.fill(colorPaper, 5);
    }

    void backTracking(int r, int c, int cnt) {

        if (answer <= cnt) {
            return;
        }

        if (r >= 9 && c > 9) {
            answer = Math.min(answer, cnt);
            return;
        }

        if (c > 9) {
            backTracking(r + 1, 0, cnt);
            return;
        }

        if (paper[r][c] == 1) {

            for (int s = Math.min(5, Math.min(10 - r, 10 - c)); s >= 1; s--) {

                if (isCoverable(r, c, s)) {

                    cover(r, c, s, 0);
                    colorPaper[s]--;

                    backTracking(r, c + 1, cnt + 1);

                    cover(r, c, s, 1);
                    colorPaper[s]++;
                }
            }

        } else {
            backTracking(r, c + 1, cnt);
        }

    }

    boolean isCoverable(int r, int c, int size) {

        if (colorPaper[size] == 0) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (paper[r + i][c + j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    void cover(int r, int c, int size, int flag) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                paper[r + i][c + j] = flag;
            }
        }
    }

   
}
