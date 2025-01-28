package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Z
 * 
 */

public class BOJ1074 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        count = -1;
        x1 = 0;
        y1 = 0;
        x2 = (int) Math.pow(2, N);
        y2 = x2;

        findSequence(r, c, x2);

        System.out.println(count);

    }

    static int count;
    static int x1, y1, x2, y2;

    static void findSequence(int r, int c, int size) {

        if (size > 2) {

            devide(r, c, size);

        } else {
            loop: for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {

                    count++;
                    if (i == r && j == c) {
                        break loop;
                    }

                }
            }
            return;
        }
    }

    static void devide(int r, int c, int size) {
        size /= 2;

        if (c >= x1 && c < (x2 - size)) {
            if (r >= y1 && r < (y2 - size)) { // 2사분면 => 1순위
                x2 -= size;
                y2 -= size;
            } else if (r >= (y2 - size) && r < y2) { // 3사분면 => 3순위
                x2 -= size;
                y1 = (y2 - size);
                count += (Math.pow(size, 2) * 2);
            }
        } else if (c >= (x2 - size) && c < x2) {
            if (r >= y1 && r < (y2 - size)) { // 1사분면 => 2순위
                x1 = (x2 - size);
                y2 -= size;
                count += Math.pow(size, 2);
            } else if (r >= (y2 - size) && r < y2) { // 4사분면 = 4순위
                x1 = (x2 - size);
                y1 = (y2 - size);
                count += (Math.pow(size, 2) * 3);
            }
        }

        findSequence(r, c, size);
    }
}
