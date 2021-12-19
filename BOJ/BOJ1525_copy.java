package BOJ;

/* 
    퍼즐
*/

import java.io.*;
import java.util.*;

public class BOJ1525_copy {

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String puzzle = "";
        String fin = "123456780";

        for (int i = 0; i < 3; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < 3; j++) {
                puzzle += line[j];
            }
        }

        if (puzzle.equals(fin)) {
            System.out.println(0);
            return;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(puzzle);
        HashSet<String> visit = new HashSet<>();
        visit.add(puzzle);

        int count = 0;

        while (!queue.isEmpty()) {

            count++;

            int size = queue.size();

            while (size-- > 0) {
                String now = queue.poll();
                int zero = now.indexOf("0");

                for (int i = 0; i < 4; i++) {
                    int nx = zero / 3 + dx[i];
                    int ny = zero % 3 + dy[i];

                    if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) {
                        continue;
                    }

                    char[] arr = now.toCharArray();
                    arr[zero] = arr[nx * 3 + ny];
                    arr[nx * 3 + ny] = '0';

                    String next = new String(arr);
                    if (!visit.contains(next)) {

                        if (next.equals(fin)) {
                            System.out.println(count);
                            return;
                        }

                        visit.add(next);
                        queue.add(next);
                    }
                }
            }

        }

        System.out.println(-1);

    }
}
