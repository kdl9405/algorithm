package BOJ;

/**
 * 생일 
 */

import java.io.*;
import java.util.*;

public class BOJ5635 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] name = new String[N];
        int[][] info = new int[N][4];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            info[i][0] = i;
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken());
            info[i][3] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(info, (a, b) -> {
            if (a[3] == b[3]) {

                if (a[2] == b[2]) {
                    return a[1] - b[1];
                }

                return a[2] - b[2];
            }

            return a[3] - b[3];
        });

        System.out.println(name[info[N - 1][0]] + "\n" + name[info[0][0]]);
    }

}