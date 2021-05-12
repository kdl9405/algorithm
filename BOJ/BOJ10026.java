package BOJ;

import java.io.*;

/* 
    적록색약 
*/
public class BOJ10026 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    dfs(i, j);
                    count++;
                }
            }
        }

        sb.append(count+" ");

        visit = new boolean[N][N];

        count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    dfs2(i, j);
                    count++;
                }
            }
        }

        sb.append(count);

        System.out.println(sb.toString());

    }

    static int N;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visit[nx][ny] && map[nx][ny] == map[x][y]) {
                    visit[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
        return;
    }

    static void dfs2(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visit[nx][ny]) {
                    if ((map[x][y] == 'B' && map[nx][ny] == 'B') || map[x][y] != 'B' && map[nx][ny] != 'B') {
                        visit[nx][ny] = true;
                        dfs2(nx, ny);
                    }

                }
            }
        }
        return;
    }
}
