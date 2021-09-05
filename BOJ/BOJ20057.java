package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
    마법사 상어와 토네이도

    //
    소수점 관련 정의가 부족. 모호.

*/
public class BOJ20057 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        a = new int[N][N];

        for (int i = 0; i < N; i++) {
            a[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int r = N / 2;
        int c = N / 2;
        int d = 0; // 방향
        int count = 1; // 거리
        int out = 0;

        loop: while (true) {

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < count; j++) {
                    r = r + dx[d];
                    c = c + dy[d];

                    // 이동 함수
                    spread(r, c, d);

                    if (r == 0 && c == 0) {
                        break loop;
                    }
                }
                d++;
                if (d == 4) {
                    d = 0;
                }
            }
          
            count++;

        }

        System.out.println(out);

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }

    static int[][] a;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };
    static int[][] dsx = { { -1, 1, -2, -1, 1, 2, -1, 1, 0 }, { -1, -1, 0, 0, 0, 0, 1, 1, 2 }, // 모래가 퍼지는 x방향
            { 1, -1, 2, 1, -1, -2, 1, -1, 0 }, { 1, 1, 0, 0, 0, 0, -1, -1, -2 } };
    static int[][] dsy = { { 1, 1, 0, 0, 0, 0, -1, -1, -2 }, { -1, 1, -2, -1, 1, 2, -1, 1, 0 }, // 모래가 퍼지는 y방향
            { -1, -1, 0, 0, 0, 0, 1, 1, 2 }, { 1, -1, 2, 1, -1, -2, 1, -1, 0 } };
    static int[] ratio = { 1, 1, 2, 7, 7, 2, 10, 10, 5 };
    static int out;

    static void spread(int r, int c, int d) {

        int sand = a[r][c];
        a[r][c] = 0;

        int move = 0;

        for (int i = 0; i < 9; i++) {
            int nr = r + dsx[d][i];
            int nc = c + dsy[d][i];

            int temp = (sand * ratio[i])/100;

            move += temp;

            if (nr < 0 || nr >= a.length || nc < 0 || nc >= a.length) {
                out += temp;

            } else {
                a[nr][nc] += temp;
            }
        }

        System.out.println(move);

        int ax = r+dx[d];
        int ay = c+dy[d];

        if (ax < 0 || ax >= a.length || ay < 0 || ay >= a.length) {
            out += (sand-move);
        }else {
            a[ax][ay] += (sand-move);
        }

    }
}
