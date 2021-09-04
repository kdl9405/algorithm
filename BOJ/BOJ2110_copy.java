package BOJ;

import java.util.*;
import java.io.*;

/* 
    재채점?
*/
public class BOJ2110_copy {
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long[] house = new long[n];

        for(int i = 0; i<n; i++){
            house[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(house);

        long max = house[n-1]/c;
        long min = 1;
        long answer = 1;

        while (min<= max) {
            long mid = (min+max)/2;
            int count = 1;
            long last = house[0];

            for(int i = 1; i<n; i++){
                if (house[i] - last >= mid) {
                    count++;
                    last = house[i];
                }
            }

            if (count>= c) {
                answer = Math.max(mid, answer);
                min = mid+1;
            }else{
                max = mid-1;
            }

        }

        System.out.println(answer);

    }
}
