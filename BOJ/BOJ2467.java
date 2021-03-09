package BJ;

import java.io.*;
import java.util.*;

/* 
    용액
*/
public class BJ2467 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
    
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i= 0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long[] result = new long[2];
        long min = Long.MAX_VALUE;
        int left = 0;
        int right = n-1;
        while (left < right) {
            long sum = arr[left]+arr[right];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                result[0] = arr[left];
                result[1] = arr[right];
            }

            if (sum > 0) {
                right--;
            }else{
                left++;
            }
        }

        System.out.println(result[0] + " "+result[1]);
    }
}
