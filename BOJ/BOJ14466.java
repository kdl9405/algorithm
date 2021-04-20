package BOJ;

import java.io.*;
import java.util.*;

/* 
    소가 길을 건너간 이유 6 

    1) 길을 '이동 못하는 길'로 간주하고 구간을 나눔.
    2) 길의 정보는 fense[][]에  좌표값은 (i-1)*N + j으로 계산하여 저장
    3) partition에 r,c에 따른 구간의 값을 저장
    4) 소들의 r,c값으로 partition을 조회해서 값이 다르면 ++;
*/
public class BOJ14466 {

    static int N, K, R;
    static boolean[][] fense;
    static int[][] partition;
    static int[][] direction = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        fense = new boolean[N * N + 1][N * N + 1];

        while (R-- > 0) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int a = (r1 - 1) * N + c1;
            int b = (r2 - 1) * N + c2;

            fense[a][b] = true;
            fense[b][a] = true;
        }

        partition = new int[N + 1][N + 1];

        int p = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (partition[i][j] != 0) {
                    continue;
                }
                dividePartion(i, j, p);
                p++;
            }
        }

        int[][] cows = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < K - 1; i++) {
            for (int j = i + 1; j < K; j++) {
                if (partition[cows[i][0]][cows[i][1]] != partition[cows[j][0]][cows[j][1]]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

    static void dividePartion(int r, int c, int p) {

        int x = ((r - 1) * N) + c;

        partition[r][c] = p;

        for (int i = 0; i < 4; i++) {

            int nr = r + direction[i][0];
            int nc = c + direction[i][1];

            if (nr <= 0 || nr > N || nc <= 0 || nc > N || partition[nr][nc] != 0) {
                continue;
            }

            int y = ((nr - 1) * N) + nc;

            if (!fense[x][y]) {
                dividePartion(nr, nc, p);
            }
        }

        return;
    }
}
