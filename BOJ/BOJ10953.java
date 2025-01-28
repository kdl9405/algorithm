package boj;

/*
 * A+B - 6
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ10953 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ10953().solution();
    }

    void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), ",", false);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append((A + B)).append("\n");

        }
        System.out.println(sb.toString().trim());
    }
}
