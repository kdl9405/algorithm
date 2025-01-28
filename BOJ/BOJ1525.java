package boj;

/*
 * 퍼즐
 */

import java.io.*;
import java.util.*;

public class BOJ1525 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] zero = new int[2];

        String puzzle = "";
        String fin = "123456780";

        for (int i = 0; i < 3; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < 3; j++) {
                puzzle += line[j];

                if (line[j].equals("0")) {
                    zero[0] = i;
                    zero[1] = j;
                }
            }
        }

        if (puzzle.equals(fin)) {
            System.out.println(0);
            return;
        }

        Queue<Status> queue = new LinkedList<>();
        queue.add(new Status(puzzle, zero[0], zero[1]));
        HashSet<String> visit = new HashSet<>();
        visit.add(puzzle);

        int count = 0;

        while (!queue.isEmpty()) {

            count++;

            int size = queue.size();

            while (size-- > 0) {
                Status now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) {
                        continue;
                    }

                    char[] arr = now.puzzle.toCharArray();
                    arr[now.x * 3 + now.y] = arr[nx * 3 + ny];
                    arr[nx * 3 + ny] = '0';

                    String next = new String(arr);
                    if (!visit.contains(next)) {

                        if (next.equals(fin)) {
                            System.out.println(count);
                            return;
                        }

                        visit.add(next);
                        queue.add(new Status(next, nx, ny));
                    }
                }
            }

        }

        System.out.println(-1);

    }
}


class Status {
    String puzzle;
    int x;
    int y;

    public Status(String puzzle, int x, int y) {
        this.puzzle = puzzle;
        this.x = x;
        this.y = y;
    }
}
