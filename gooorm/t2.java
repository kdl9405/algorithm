package gooorm;

import java.io.*;
import java.util.*;

public class t2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        visit = new boolean[50][50][50][50];
        System.out.println(BFS(x1, y1, x2, y2));

    }

    static int n;
    static char[][] map;
    static boolean[][][][] visit;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    static int BFS(int x1, int y1, int x2, int y2) {
        int count = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x1, y1, x2, y2 });
        visit[x1][y1][x2][y2] = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] now = queue.poll();

                if (map[now[0]][now[1]] == 'D' && map[now[2]][now[3]] == 'D') {
                    return count;
                }

                for (int i = 0; i < 4; i++) {

                    int nx1 = now[0];
                    int ny1 = now[1];
                    int nx2 = now[2];
                    int ny2 = now[3];

                    if (map[nx1][ny1] != 'D') {

                        if (nx1 + dx[i] >= 0 && nx1 + dx[i] < n) {
                            nx1 += dx[i];
                        }
                        if (ny1 + dy[i] >= 0 && ny1 + dy[i] < n) {
                            ny1 += dy[i];
                        }

                        if (map[nx1][ny1] == 'X') {
                            nx1 = now[0];
                            ny1 = now[1];
                        }
                      
                    }

                    if (map[nx2][ny2] != 'D') {

                        if (nx2 + dx[i] >= 0 && nx2 + dx[i] < n) {
                            nx2 += dx[i];
                        }
                        if (ny2 + dy[i] >= 0 && ny2 + dy[i] < n) {
                            ny2 += dy[i];
                        }

                        if (map[nx2][ny2] == 'X') {
                            nx2 = now[2];
                            ny2 = now[3];
                        }
                       

                    }

                    if (!visit[nx1][ny1][nx2][ny2]) {
                        visit[nx1][ny1][nx2][ny2] = true;

                        queue.add(new int[]{nx1,ny1,nx2,ny2});
                    }

                }

            }

            count++;

        }

        return -1;
    }
}
