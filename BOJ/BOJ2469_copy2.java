package boj;

import java.io.*;
import java.util.*;

/*
 * 사다리타기
 * 
 * 성공
 */

public class BOJ2469_copy2 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        char[] end = br.readLine().toCharArray();
        char[] start = new char[k];
        for (int i = 0; i < k; i++) {
            start[i] = (char) ('A' + i);
        }

        char[][] line = new char[n][k - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            line[i] = br.readLine().toCharArray();
            if (line[i][0] == '?') {
                index = i;
            }
        }

        for (int i = 0; i < index; i++) {
            for (int j = 0; j < k - 1; j++) {
                if (line[i][j] == '-') {
                    char c = start[j];
                    start[j] = start[j + 1];
                    start[j + 1] = c;
                }
            }
        }

        for (int i = n - 1; i > index; i--) {
            for (int j = 0; j < k - 1; j++) {
                if (line[i][j] == '-') {
                    char c = end[j];
                    end[j] = end[j + 1];
                    end[j + 1] = c;
                }
            }
        }

        boolean posible = true;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k - 1; i++) {
            if (start[i] == end[i]) {
                sb.append('*');
            } else if (start[i] == end[i + 1] && start[i + 1] == end[i]) {
                sb.append('-');
                char c = start[i];
                start[i] = start[i + 1];
                start[i + 1] = c;
            } else {
                posible = false;
                break;
            }
        }

        if (!posible) {
            sb = new StringBuilder();
            for (int i = 0; i < k - 1; i++) {
                sb.append('x');
            }
        }

        System.out.println(sb.toString().trim());

    }

}
