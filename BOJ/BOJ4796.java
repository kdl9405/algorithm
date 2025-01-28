package boj;

import java.io.*;
import java.util.*;

/*
 * 캠핑
 */

public class BOJ4796 {

    public static void main(String[] args) throws IOException {

        new BOJ4796().solution();

    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int L, P, V;

        int T = 1;
        StringBuilder answer = new StringBuilder();
        while (true) {

            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            int d = (V / P * L) + (Math.min(L, V % P));
            answer.append("Case ").append(T).append(": ").append(d).append("\n");

            T++;

        }

        System.out.println(answer.toString().trim());

    }
}
