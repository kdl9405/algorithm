package BOJ;

import java.io.*;
import java.util.*;

/* 
    성벽
*/
public class BOJ2234 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        castle = new int[m][n];

        for (int i = 0; i < m; i++) {
            castle[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        room = new int[m][n];
        room_size = new HashMap<>();
        
        max = 0;
        int number = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (room[i][j] != 0) {
                    continue;
                }
                findRoom(i, j, number);
                number++;
            }
        }

        int sum = max;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j<n-1 && room[i][j] != room[i][j+1]) {
                    sum = Math.max(sum, room_size.get(room[i][j])+room_size.get(room[i][j+1]));
                }
                if (i<m-1 && room[i][j] != room[i+1][j]) {
                    sum = Math.max(sum, room_size.get(room[i][j])+room_size.get(room[i+1][j]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(room_size.size()+"\n");
        sb.append(max+"\n");
        sb.append(sum);

        System.out.println(sb.toString());

    }

    static int n, m, max;
    static int[][] castle;
    static int[][] room;
    static HashMap<Integer, Integer> room_size;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { -1, 0, 1, 0 };

    static void findRoom(int r, int c, int number) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { r, c });
        room[r][c] = number;

        int size = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                if ((castle[now[0]][now[1]] & 1 << i) == 0) {

                    int x = now[0] + dx[i];
                    int y = now[1] + dy[i];

                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (room[x][y] == 0) {
                            room[x][y] = number;
                            queue.offer(new int[] { x, y });
                        }
                    }
                }
            }
            size++;
        }

        room_size.put(number, size);
        max = Math.max(max, size);
        return;
    }

}
