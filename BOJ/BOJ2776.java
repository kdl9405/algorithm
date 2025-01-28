package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ2776 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int c = Integer.parseInt(br.readLine());

            HashSet<Integer> one = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            while (c-- > 0) {

                one.add(Integer.parseInt(st.nextToken()));
            }

            c = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while (c-- > 0) {
                int num = Integer.parseInt(st.nextToken());

                if (one.contains(num)) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            }

        }

        System.out.println(sb.toString().trim());

    }
}
