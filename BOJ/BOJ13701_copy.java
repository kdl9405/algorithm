package boj;

/*
 * 중복 제거
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ13701_copy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] number = new int[1 << 20];

        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            int a = Integer.parseInt(s);
            int x = a / 32;
            int y = a % 32;
            if ((number[x] & (1 << y)) != (1 << y)) {
                number[x] |= (1 << y);
                sb.append(s).append(" ");
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();
    }
}
