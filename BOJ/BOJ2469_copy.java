package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
 * 사다리 타기
 * 
 * 실패...
 */

public class BOJ2469_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        positon = new char[4][k];

        for (int i = 0; i < k; i++) {
            positon[0][i] = (char) ('A' + i);
        }
        positon[3] = br.readLine().toCharArray();

        line = new char[n][k - 1];

        int index = 0;
        for (int i = 0; i < n; i++) {
            String l = br.readLine();
            if (l.charAt(0) == '?') {
                index = i;
                break;
            }
            line[i] = l.toCharArray();
        }

        for (int x = 0; x < k; x++) {
            down(x, 0, index, (char) ('A' + x));
        }

        for (int i = index + 1; i < n; i++) {
            String l = br.readLine();
            line[i] = l.toCharArray();
        }

        for (int x = 0; x < k; x++) {
            down2(x, index + 1, n, x);
        }


        for (int i = 0; i < k - 1; i++) {
            if (positon[1][i] == positon[2][i + 1] && positon[1][i + 1] == positon[2][i]) {
                line[index][i] = '-';
            } else if (positon[1][i] == positon[2][i] && positon[1][i + 1] == positon[2][i + 1]) {
                line[index][i] = '*';
            } else {
                Arrays.fill(line[index], 'x');
                break;
            }
        }

        System.out.println(new String(line[index]));

    }

    static int k, n;
    static char[][] line;
    static char[][] positon;

    static void down(int index, int from, int to, char c) {

        if (from == to) {

            positon[1][index] = c;

            // System.out.println(c + " " + index);

            return;
        }

        int l = index;
        int r = index;
        if (index > 0 && line[from][index - 1] == '-') {
            l--;

            while (l > 0) {
                l--;
                if (line[from][l] == '*') {
                    l++;
                    break;
                }
            }

            down(l, from + 1, to, c);
        } else if (index < k - 2 && line[from][index] == '-') {

            while (r < k - 2) {
                r++;
                if (line[from][r] == '*') {
                    break;
                }
            }

            down(r, from + 1, to, c);
        } else {
            down(index, from + 1, to, c);
        }

    }

    static void down2(int index, int from, int to, int x) {

        if (from == to) {

            positon[2][x] = positon[3][index];

            return;
        }

        int l = index;
        int r = index;
        if (index > 0 && line[from][index - 1] == '-') {
            l--;

            while (l > 0) {
                l--;
                if (line[from][l] == '*') {
                    l++;
                    break;
                }
            }

            down2(l, from + 1, to, x);
        } else if (index <= k - 2 && line[from][index] == '-') {

            while (r <= k - 2) {
                if (line[from][r] == '*') {
                    break;
                }
                r++;
            }

            down2(r, from + 1, to, x);
        } else {
            down2(index, from + 1, to, x);
        }

    }

}
