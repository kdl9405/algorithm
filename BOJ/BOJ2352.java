package BOJ;

/* 
    반도체 설계
 */

import java.io.*;
import java.util.*;

public class BOJ2352 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ2352().solution();
    }

    void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] port = new int[n + 1];
        int[] countIdx = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        port[1] = Integer.parseInt(st.nextToken());
        countIdx[1] = port[1];
        int max = 1;
        for (int i = 2; i <= n; i++) {
            port[i] = Integer.parseInt(st.nextToken());
            if (countIdx[max] < port[i]) {
                max++;
                countIdx[max] = port[i];
            } else {
                for (int j = max - 1; j >= 0; j--) {
                    if (countIdx[j] < port[i] && countIdx[j + 1] > port[i]) {
                        countIdx[j + 1] = port[i];
                        break;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
