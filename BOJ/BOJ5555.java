package boj;

/**
 * 반지
 */

import java.io.*;

public class BOJ5555 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        while (N-- > 0) {
            StringBuilder ring = new StringBuilder(br.readLine());

            if (ring.length() < S.length()) {
                continue;
            }

            ring.append(ring);

            if (ring.toString().contains(S)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
