package BOJ;

/* 
    뱀 
*/

import java.io.*;
import java.util.*;

public class BOJ3190 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        boolean[][] apple = new boolean[N+1][N+1];

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            apple[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        HashMap<Integer, String> dir = new HashMap<>();
        int L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            dir.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        int time = 0;

        int x = 1;
        int y = 1;
        int d = 0;

        boolean[][] board = new boolean[N+1][N+1];
        LinkedList<int[]> snake = new LinkedList<>();
        snake.add(new int[] { 1, 1 });
        board[1][1] = true;

        while (true) {

            time++;

            x +=dx[d];
            y +=dy[d];

            if (x <= 0 || x > N || y <= 0 || y > N || board[x][y]) {
                break;
            }

            board[x][y] = true;
            snake.addFirst(new int[] { x, y });
            if (apple[x][y]) {
                apple[x][y] = false;
            } else {
                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = false;
            }

            if (dir.containsKey(time)) {
                if (dir.get(time).equals("D")) {
                    d = (d + 1) % 4;
                } else {
                    d = (d + 3) % 4;
                }
            }


            System.out.println(time);
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=N; j++){
                    System.out.print(board[i][j]? "X": ".");
                }System.out.println();
            }
        }

        System.out.println(time);

    }

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
}
