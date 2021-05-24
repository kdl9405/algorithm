package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
    새로운 게임


    1. 말이 가장 아래에 있는지 체크하면서 이동..
    2. 어떻게 겹쳐진 말을 체크할건가..(맨 아래, 맨 위도 체크해야함)
    3. 4개 쌓이면 끝!!!


*/

public class BOJ17780 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        not_Move = new boolean[k + 1];

        map = new int[n + 1][n + 1][4]; // 0:컬러, 1: 맨 아래 말, 2: 맨 위에 말, 3: 개수
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken());
            }
        }

        p = new int[k + 1][3]; // 0:x, 1:y, 2:d
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
            p[i][2] = Integer.parseInt(st.nextToken());

            map[p[i][0]][p[i][1]][1] = i;
            map[p[i][0]][p[i][1]][2] = i;
            map[p[i][0]][p[i][1]][3] = 1;

        }

        finish = false;
        int count = 0;         
        while (!finish && count <= 1000) {

            for (int i = 1; i <= k; i++) {
                if (not_Move[i]) {
                    continue;
                }
                blue = false;
                move(i, p[i][0] + dx[p[i][2]], p[i][1] + dy[p[i][2]]);
               
            }
            count++;

        }

        if (count > 1000) {
            count = -1;
        }
        System.out.println(count);

    }

    static void testPrint(){
        StringBuilder sb = new StringBuilder();
        sb.append("-----------\n");
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                sb.append(map[i][j][3]+" ");
            }sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static int n;
    static int[][][] map;
    static int[][] p;
    static boolean[] not_Move;
    static boolean blue;
    static boolean finish;
    static int[] dx = { 0, 0, 0, -1, 1 };
    static int[] dy = { 0, 1, -1, 0, 0 };

    static void move(int k, int nx, int ny) {

        if (nx > n || nx < 1 || ny > n || ny < 1 || map[nx][ny][0] == 2) {
            if (blue) {
                return;
            } else {
                blue = true;
                p[k][2] = switch_D(p[k][2]);
                move(k, p[k][0] + dx[p[k][2]], p[k][1] + dy[p[k][2]]);
            }
            return;
        }
        if (map[nx][ny][0] == 0) {

            if (map[nx][ny][1] == 0) { // 빈칸이면
                int up = map[p[k][0]][p[k][1]][2];
                map[nx][ny][1] = k;
                map[nx][ny][2] = up;
                map[nx][ny][3] = map[p[k][0]][p[k][1]][3];

                map[p[k][0]][p[k][1]][1] = 0;
                map[p[k][0]][p[k][1]][2] = 0;
                map[p[k][0]][p[k][1]][3] = 0;

                p[k][0] = nx;
                p[k][1] = ny;
                p[up][0] = nx;
                p[up][1] = ny;

            } else {
                not_Move[k] = true;

                int up = map[p[k][0]][p[k][1]][2];
                map[nx][ny][2] = up;
                map[nx][ny][3] += map[p[k][0]][p[k][1]][3];

                if (map[nx][ny][3] >= 4) {
                    finish = true;
                }

                map[p[k][0]][p[k][1]][1] = 0;
                map[p[k][0]][p[k][1]][2] = 0;
                map[p[k][0]][p[k][1]][3] = 0;

                p[up][0] = nx;
                p[up][1] = ny;
            }
            

            return;
        }

        if (map[nx][ny][0] == 1) {

            if (map[nx][ny][1] == 0) { // 빈칸이면
                int up = map[p[k][0]][p[k][1]][2];
                map[nx][ny][1] = up;
                map[nx][ny][2] = k;
                map[nx][ny][3] = map[p[k][0]][p[k][1]][3];

                not_Move[k] = true;
                not_Move[up] = false;
                
                map[p[k][0]][p[k][1]][1] = 0;
                map[p[k][0]][p[k][1]][2] = 0;
                map[p[k][0]][p[k][1]][3] = 0;


                p[k][0] = nx;
                p[k][1] = ny;
                p[up][0] = nx;
                p[up][1] = ny;
            } else {

                int up = map[nx][ny][1];
                map[nx][ny][1] = up;
                map[nx][ny][2] = k;
                map[nx][ny][3] += map[p[k][0]][p[k][1]][3];

                if (map[nx][ny][3] >= 4) {
                    finish = true;
                }

                not_Move[k] = true;
                not_Move[up] = false;

                map[p[k][0]][p[k][1]][1] = 0;
                map[p[k][0]][p[k][1]][2] = 0;
                map[p[k][0]][p[k][1]][3] = 0;


                p[k][0] = nx;
                p[k][1] = ny;
                p[up][0] = nx;
                p[up][1] = ny;
            }

            return;
        }

    }

    static int switch_D(int x) {
        int nd = 0;

        switch (x) {
            case 1:
                nd = 2;
                break;
            case 2:
                nd = 1;
                break;
            case 3:
                nd = 4;
                break;
            case 4:
                nd = 3;
                break;
        }

        return nd;
    }
}
