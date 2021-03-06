package BJ;

import java.io.*;
import java.util.*;

/* 
    기차가 어둠을 헤치고 은하수를

    문자열 처리 - > 540ms
*/

public class BJ15787_copy {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String d = "00000000000000000000";

        char[][] train = new char[n + 1][20];
        for (int i = 0; i <= n; i++) {
            train[i] = d.toCharArray();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int x = 0;
            String t = "";

            switch (oper) {
            case 1:
                x = Integer.parseInt(st.nextToken());
                train[i][x - 1] = '1';

                break;
            case 2:
                x = Integer.parseInt(st.nextToken());
                train[i][x - 1] = '0';
                break;

            case 3:
                t = new String(train[i]);
                t = t.substring(0, 19);
                t = "0" + t;
                train[i] = t.toCharArray();

                break;
            case 4:
                t = new String(train[i]);
                t = t.substring(1, 20);
                t = t + "0";
                train[i] = t.toCharArray();

                break;
            }
        }

        HashSet<String> trains = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            trains.add(new String(train[i]));
       }
        System.out.println(trains.size());

    }
}
