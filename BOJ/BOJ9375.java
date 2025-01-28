package boj;

import java.io.*;
import java.util.*;

/*
 * 패션왕 신해빈
 * 
 */
public class BOJ9375 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                String x = st.nextToken();
                String y = st.nextToken();

                map.put(y, map.getOrDefault(y, 0) + 1);
            }

            int count = 1;
            for (String y : map.keySet()) {
                count *= (map.get(y) + 1);
            }

            count -= 1;

            sb.append(count + "\n");
        }

        System.out.println(sb.toString());
    }
}
