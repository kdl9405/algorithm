package BOJ;

import java.io.*;
import java.util.*;

/* 
    미네랄
*/

public class BOJ2933 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {

            int nr = r - Integer.parseInt(st.nextToken());

            if (i % 2 == 0) { // 왼쪽에서 던짐
                for (int j = 0; j < c; j++) {
                    if (map[nr][j] == 'x') {
                        remove(nr, j);
                        break;
                    }
                }
            } else { // 오른쪽에서 던짐
                for (int j = c - 1; j >= 0; j--) {
                    if (map[nr][j] == 'x') {
                        remove(nr, j);
                        break;
                    }
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            sb.append(new String(map[i]) + "\n");
        }

        System.out.println(sb.toString());

    }

    static int r, c;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static void remove(int x, int y) {

        map[x][y] = '.';

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx >= 0 && xx < r && yy >= 0 && yy < c) {
                if (map[xx][yy] == 'x') {

                    visit = new boolean[r][c];
                    visit[xx][yy] = true;
                    boolean check = false;

                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] { xx, yy });

                    loop: while (!queue.isEmpty()) {

                        int[] now = queue.poll();

                        for (int j = 0; j < 4; j++) {
                            int nx = now[0] + dx[j];
                            int ny = now[1] + dy[j];

                            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                                if (map[nx][ny] == 'x' && !visit[nx][ny]) {
                                    visit[nx][ny] = true;
                                    queue.add(new int[] { nx, ny });
                                    if (nx == r - 1) {
                                        check = true;
                                        break loop;
                                    }
                                }
                            }
                        }
                    }


                    if (!check) {
                        move();
                    }
                }
            }

        }

    }

    static void move() {

        int height = r;

        for (int j = 0; j < c; j++) {

            for (int i = r - 1; i >= 0; i--) {

                if (visit[i][j]) {

                    for (int k = i + 1; k < r; k++) {                        

                        if (map[k][j] == 'x' && !visit[k][j]) {
                            height = Math.min(height, k - i - 1);
                            break;
                        } else if (k == r - 1) {
                            height = Math.min(height, k - i);
                            break;
                        }
                    }

                }
            }
        }

        for (int i = r - 1; i >= 0; i--) {
            for (int j = 0; j < c; j++) {

                if (visit[i][j]) {

                    map[i + height][j] = 'x';
                    map[i][j] = '.';
                }
            }
        }
     
        return;
    }
}
