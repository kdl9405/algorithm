package softeer;

import java.util.*;
import java.io.*;

public class s0330_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String line = br.readLine();

        boolean[] pick = new boolean[N];

        int count = 0;
        int i = 0;
        int j = 0;
        for (; i < N; i++) {

            if (line.charAt(i) == 'H') {

                for (; j < N && j-i <=K; j++) {
                    if (line.charAt(j) == 'P' && Math.abs(j-i)<=K && !pick[j]) {
                        pick[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
