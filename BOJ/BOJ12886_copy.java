package boj;

import java.io.*;
import java.util.*;

/*
 * 돌 그룹
 * 
 * 988ms
 */
public class BOJ12886_copy {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] stoneGroup = new int[3];
        stoneGroup[0] = Integer.parseInt(st.nextToken());
        stoneGroup[1] = Integer.parseInt(st.nextToken());
        stoneGroup[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(stoneGroup);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(stoneGroup);
        HashSet<String> loopCheck = new HashSet<>();
        loopCheck.add(stoneGroup[0] + " " + stoneGroup[1] + " " + stoneGroup[2]);

        int answer = 0;

        loop: while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] stone = queue.poll();

                if (stone[0] == stone[1] && stone[1] == stone[2]) {
                    answer = 1;
                    break loop;
                }

                for (int i = 0; i < 2; i++) {
                    for (int j = i + 1; j < 3; j++) {
                        if (stone[i] != stone[j]) {
                            int[] temp = stone.clone();

                            temp[j] -= temp[i];
                            temp[i] *= 2;
                            Arrays.sort(temp);

                            if (!loopCheck.contains(temp[0] + " " + temp[1] + " " + temp[2])) {
                                loopCheck.add(temp[0] + " " + temp[1] + " " + temp[2]);
                                queue.add(temp);
                            }

                        }
                    }
                }
            }

        }


        System.out.println(answer);
    }
}
