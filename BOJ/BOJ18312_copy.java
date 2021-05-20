package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
    시각 

    java 11 - 1056ms
*/

public class BOJ18312_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String k = st.nextToken();

        int h = 0;
        int m = 0;
        int s = 0;

        StringBuilder t;
        int count = 0;

        while (h <= n) {

           t = new StringBuilder();
           t.append(h);
           if (t.length() == 1) {
               t.append("0");
           }
           t.append(m);
           if (t.length() == 3) {
               t.append("0");
           }
           t.append(s);
           if (t.length() == 5) {
               t.append("0");
           }

           if (t.toString().replaceAll(k, "").length() < 6) {
               count++;
           }

           s++;
           if (s == 60) {
               s = 0;
               m++;
               if (m == 60) {
                   m = 0;
                   h++;
               }
           }
        }

        System.out.println(count);
    }
}
