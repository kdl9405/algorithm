package BOJ;

import java.io.*;
import java.util.*;

/* 
    부분합 
*/
public class BOJ1806 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = 100001;
        long sum = 0;

        int left = 0;
        int right = 0;

        while (true) {           

            if (sum >=s) {
                min = Math.min(right-left, min);
                sum -= arr[left];
                left++;
            }else if (right == n) {
                break;
            }           
            else{
                sum += arr[right];
                right++;
            }            
        }
        
        if (min == 100001) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }

    }
}