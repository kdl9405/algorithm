package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1931 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] time = new int[n][2];

        StringTokenizer st;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (t1,t2)->{
            if (t1[1] == t2[1]) {
                return t1[0] -  t2[0];
            }else{
                return t1[1] - t2[1];
            }
        });

        int end = 0;
        int count = 0;

        for(int i = 0; i<n; i++){
            if (time[i][0] >= end) {
                count++;
                end = time[i][1];
            }
        }

        System.out.println(count);

    }
}
