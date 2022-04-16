package BOJ;

/*
카드 문자열
*/

import java.io.*;
import java.util.*;

public class BOJ13417 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();

        StringTokenizer st;
        StringBuilder sb;
        while (T-- > 0) {

            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            sb.append(st.nextToken());
            while (N-- > 1) {
                char next = st.nextToken().charAt(0);
                if (next <= sb.charAt(0)) {
                    sb.insert(0, next);
                } else {
                    sb.append(next);
                }
            }
            answer.append(sb).append("\n");
        }

        System.out.println(answer.toString().trim());
    }

}