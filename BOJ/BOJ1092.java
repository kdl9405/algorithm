package BOJ;

import java.io.*;
import java.util.*;

/* 
    배
*/

public class BOJ1092 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] crane = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] box = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(crane);
        
        Arrays.sort(box);

        if (box[m - 1] > crane[n - 1]) {
            System.out.println(-1);
        } else {
            int[] cranePart = new int[n];
            int j = 0;
            for (int i = 0; i < m; i++) {
                while (box[i] > crane[j]) {
                    j++;
                }
                cranePart[j]++;
            }

              int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(cranePart[i], max);
            }

            if (max == cranePart[n - 1]) {
                System.out.println(max);
            } else {
                int count = m / n;
                if (m % n != 0) {
                    count++;
                }

                max = count;

                int possible = 0;
                for (int i = n - 1; i >= 0; i--) {
                    if (cranePart[i] < count) {
                        possible += (count - cranePart[i]);
                    } else {
                        possible -= (cranePart[i] - count);
                    }
                    if (possible < 0) {
                        int temp = count + Math.abs(possible) / (n - i);
                        if (Math.abs(possible) % (n - i) != 0) {
                            temp++;
                        }
                        max = Math.max(max, temp);
                       
                    }
                }
                System.out.println(max);

            }

        }

    }
}
