package BOJ;

/* 
    역사
*/

import java.io.*;
import java.util.*;

public class BOJ1613 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] sequence = new int[n + 1][n + 1];

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sequence[a][b] = -1;
            sequence[b][a] = 1;
        }

        for (int m = 1; m <= n; m++) {
            for (int a = 1; a <= n; a++) {

                if(a==m){
                    continue;
                }

                for (int b = 1; b <= n; b++) {

                    if (b == m || b == a) {
                        continue;
                    }

                    if (sequence[a][b] == 0 ) {
                        
                    if (sequence[a][m] == sequence[m][b] && sequence[a][m] != 0) {
                            sequence[a][b] = sequence[a][m];
                            sequence[b][a] = sequence[m][a];
                        }

                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        int s = Integer.parseInt(br.readLine());
        while (s-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            answer.append(sequence[a][b]).append("\n");
        }

        System.out.println(answer.toString());

    }
}
