package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
    인내의 도미노 장인 호석
*/
public class pro178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        result = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        point = 0;

        while (R-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String d = st.nextToken();

            attack(x, y, d);

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            result[x][y] = false;
        }

        System.out.println(point);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<= M; j++){
                if (result[i][j]) {
                    sb.append("F ");
                }else{
                    sb.append("S ");
                }
            }sb.append("\n");
        }
        System.out.println(sb.toString().trim());

    }

    static int[][] map;
    static boolean[][] result;
    static int point;

    static void attack(int x, int y, String d) {

        int count = 1;
        int distance = map[x][y];

        int nx = x;
        int ny = y;

        result[x][y] = true;
        switch (d) {
        case "E":
            while (distance-- > 1) {
                ny++;
                if (ny >= map[0].length) {
                    break;
                }
                if (!result[nx][ny]) {
                    count++;
                    result[nx][ny] = true;
                    distance = Math.max(distance, map[nx][ny]);
                }
            }
            break;

        case "W":
            while (distance-- > 1) {
                ny--;
                if (ny < 1) {
                    break;
                }
                if (!result[nx][ny]) {
                    count++;
                    result[nx][ny] = true;
                    distance = Math.max(distance, map[nx][ny]);
                }
            }
            break;

        case "S":
            while (distance-- > 1) {
                nx++;
                if (nx >= map.length) {
                    break;
                }
                if (!result[nx][ny]) {
                    count++;
                    result[nx][ny] = true;
                    distance = Math.max(distance, map[nx][ny]);
                }
            }
            break;

        case "N":
            while (distance-- > 1) {
                nx--;
                if (nx < 1) {
                    break;
                }
                if (!result[nx][ny]) {
                    count++;
                    result[nx][ny] = true;
                    distance = Math.max(distance, map[nx][ny]);
                }
            }
            break;
        }

        point+= count;
    }
}
