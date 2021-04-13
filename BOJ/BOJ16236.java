package BOJ;

import java.io.*;
import java.util.*;

/* 
    아기 상어

    980ms
*/
public class BOJ16236 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        shark = 2;
        map = new int[N][N];
        fishes = new LinkedList<>();
        for (int i = 0; i <= 6; i++) {
            fishes.add(new LinkedList<>());
        }

        StringTokenizer st;
        int[] now = new int[2];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    now[0] = i;
                    now[1] = j;
                    map[i][j] = 0;
                } else if (map[i][j] != 0) {
                    fishes.get(map[i][j]).add(new int[] { i, j });
                }

            }
        }

        int time = 0;
        int eat = 0;
        while (true) {

            int fishSize = -1;
            int fishIndex = -1;

            int distance = 9999;
            for (int i = 1; i < shark && i<=6; i++) {
                
                int j = 0;
                for (int[] fish : fishes.get(i)) {
                    int move = moveCount(now[0], now[1], fish[0], fish[1]);

                    if (move < distance) {
                        fishSize = i;
                        fishIndex = j;
                        distance = move;
                    } else if (move == distance) {
                        if (fishes.get(fishSize).get(fishIndex)[0] > fish[0]) {
                            fishSize = i;
                            fishIndex = j;
                        } else if (fishes.get(fishSize).get(fishIndex)[0] == fish[0]) {
                            if (fishes.get(fishSize).get(fishIndex)[1] > fish[1]) {
                                fishSize = i;
                                fishIndex = j;
                            }
                        }
                    }

                    j++;
                }
            }

            if (fishSize == -1 && fishIndex == -1) {
                break;
            }

          
            time += distance;
            now[0] = fishes.get(fishSize).get(fishIndex)[0];
            now[1] = fishes.get(fishSize).get(fishIndex)[1];


            eat ++;
            if(eat == shark){
                eat = 0;
                shark++;
            }

            fishes.get(fishSize).remove(fishIndex);

        }

        System.out.println(time);

    }

    static int N;
    static int shark;
    static int[][] map;
    static List<List<int[]>> fishes;
    static boolean[][] visit;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    static int moveCount(int x, int y, int tx, int ty) {
        int count = 0;

        visit = new boolean[N][N];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y });

        loop: while (true) {
            count++;
            Queue<int[]> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                if (visit[now[0]][now[1]]) {
                    continue;
                }
                visit[now[0]][now[1]] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (nx == tx && ny == ty) {
                            break loop;
                        }
                        if (map[nx][ny] <= shark && !visit[nx][ny]) {
                            temp.add(new int[] { nx, ny });
                        }
                    }
                }
            }

            if (temp.isEmpty()) {
                count = 10000;
                break;
            } else {
                queue.addAll(temp);
            }
        }

        return count;
    }
}
