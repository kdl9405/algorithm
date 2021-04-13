package BOJ;

import java.io.*;
import java.util.*;

/* 
    기차가 어둠을 헤치고 은하수를

    비트 연산
*/

public class BOJ15787 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] train = new int[n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int x = 0;

            switch (oper) {
            case 1:
                x = Integer.parseInt(st.nextToken());
                train[i] = (train[i] | 1 << (20 - x));
                break;
            case 2:
                x = Integer.parseInt(st.nextToken());
                train[i] = (train[i] & ~(1 << (20 - x)));

                break;

            case 3:
                train[i] = (train[i]) >> 1;

                break;
            case 4:
                train[i] = (train[i]) << 1;
                train[i] = (train[i] & ~(1 << 20));

                break;
            }
        }

        HashSet<Integer> trains = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            trains.add(train[i]);
        }

        System.out.println(trains);
        System.out.println(trains.size());

    }
}
