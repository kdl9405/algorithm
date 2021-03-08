package BJ;

import java.io.*;
import java.util.*;

/* 
    달력
*/

public class BJ20207 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] works = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            works[i][0] = Integer.parseInt(st.nextToken());
            works[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] calender = new int[367];

        for(int[] work : works){
            for(int i = work[0]; i<=work[1]; i++){
                calender[i]++;
            }
        }

        int day = 0;
        int count = 0;
        int total = 0;
        for(int i = 1; i<=366; i++){
            if (calender[i] == 0) {
                total += (day*count);
                day = 0;
                count = 0;
            }else{
                day++;
                count = Math.max(count, calender[i]);
            }
        }


        System.out.println(total);

    }
}
