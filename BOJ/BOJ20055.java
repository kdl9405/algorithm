package BOJ;

/* 
    컨베이어 벨트 위의 로봇
*/

import java.io.*;
import java.util.*;

public class BOJ20055 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] belt = new int[N * 2];
        List<Integer> position = new ArrayList<>();
        for (int i = 0; i < N * 2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
            position.add(i);
        }

        boolean[] isRobot = new boolean[N * 2];
        int stage = 1;

        int len = 2 * N;
        int count = 0;

        while (true) {

            int last = position.get(len - 1);
            position.remove(len - 1);
            position.add(0, last);

            int down = position.get(N-1);
            if (isRobot[down]) {
                isRobot[down] = false;
            }

            for (int i = N - 1; i >= 0; i--) {
                int now = position.get(i);
                int next = position.get(i + 1);

                if (isRobot[now] && !isRobot[next] && belt[next] > 0) {
                    isRobot[now] = false;
                    isRobot[next] = true;
                    belt[next]--;
                    if (belt[next] == 0) {
                        count++;
                    }
                }
            }

            if (isRobot[down]) {
                isRobot[down] = false;
            }            

            int now = position.get(0);

            if (!isRobot[now] && belt[now] > 0) {
                isRobot[now] = true;
                belt[now]--;
                if (belt[now] == 0) {
                    count++;
                }
            }

            if(count >= K){
                break;
            }

            stage++;

        }

        System.out.println(stage);
    }
}
