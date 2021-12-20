package BOJ;

/* 
    예산
*/

import java.io.*;
import java.util.*;

public class BOJ2512 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] budget = new int[N];

        int min = 0;
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budget[i]);
        }

        int money = Integer.parseInt(br.readLine());

        
        int mid;

        int answer = 0;

        while (min <= max) {
            mid = (min + max) / 2;

            int temp = 0;
            for (int i = 0; i < N; i++) {
                temp += (Math.min(budget[i], mid));
            }

            if (temp > money) {
                max = mid - 1;
            } else {
                answer = mid;
                min = mid + 1;
            }


        }

        System.out.println(answer);
    }
}
