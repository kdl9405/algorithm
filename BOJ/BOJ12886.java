package BOJ;

import java.io.*;
import java.util.*;

/* 
    돌 그룹

    // 언제까지 단계를 반복하느냐가 관건...  아직 잘 모르겠음
*/
public class BOJ12886 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] stoneGroup = new int[3];
        stoneGroup[0] = Integer.parseInt(st.nextToken());
        stoneGroup[1] = Integer.parseInt(st.nextToken());
        stoneGroup[2] = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(stoneGroup);
        HashSet<String> loopCheck = new HashSet<>();

        int answer = 0;

        loop: for (int x = 0; x < 8; x++) {
            int size = queue.size();
            while (size-- > 0) {
                int[] stone = queue.poll();
                Arrays.sort(stone);

                if (stone[0] == stone[1] && stone[1] == stone[2]) {
                    answer = 1;
                    break loop;
                }

                if (loopCheck.contains(stone[0] + " " + stone[1] + " " + stone[2])) {
                    continue;
                } else {
                    loopCheck.add(stone[0] + " " + stone[1] + " " + stone[2]);
                }

                if (stone[0] != stone[1]) {
                    queue.add(new int[] { stone[0] * 2, stone[1] - stone[0], stone[2] });
                }
                if (stone[0] != stone[2]) {
                    queue.add(new int[] { stone[0] * 2, stone[1], stone[2] - stone[0] });
                }
                if (stone[1] != stone[2]) {
                    queue.add(new int[] { stone[0], stone[1] * 2, stone[2] - stone[1] });
                }
            }
        }

        System.out.println(answer);
    }
}