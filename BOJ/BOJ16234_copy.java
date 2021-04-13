package BOJ;

import java.io.*;
import java.util.*;

/* 
    인구 이동

    2640 ms
*/

public class BOJ16234_copy {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visit;
        List<List<String>> united; // 연합
        int count = 0;
        while (true) {
            united = new ArrayList<>();
            visit = new boolean[N][N];
            int sum = 0;

            for (int i = 0; i < N; i++) { // 연합 탐색
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        visit[i][j] = true;
                        sum = arr[i][j];
                        Queue<String> queue = new LinkedList<>();
                        queue.add(i + " " + j);

                        List<String> set = new ArrayList<>();
                        set.add(i + " " + j);

                        while (!queue.isEmpty()) {
                            int[] now = Arrays.stream(queue.poll().split(" ")).mapToInt(Integer::parseInt).toArray();
                            for (int k = 0; k < 4; k++) {
                                int nx = now[0] + dx[k];
                                int ny = now[1] + dy[k];
                                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                    if (!visit[nx][ny]) {
                                        int d = Math.abs(arr[now[0]][now[1]] - arr[nx][ny]);
                                        if (d >= L && d <= R) {
                                            queue.add(nx + " " + ny);
                                            set.add(nx + " " + ny);
                                            visit[nx][ny] = true;
                                            sum += arr[nx][ny];
                                        }
                                    }
                                }
                            }
                        }

                        if (set.size() > 1) {
                            sum /= set.size();
                            for (String s : set) {
                                int[] str = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
                                arr[str[0]][str[1]] = sum;
                            }

                            united.add(set);
                        }
                    }
                }
            }

            if (united.isEmpty()) {
                break;
            }
          
            count++;

        }

        System.out.println(count);

    }

    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

}
