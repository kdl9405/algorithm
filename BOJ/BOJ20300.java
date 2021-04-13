package BOJ;

import java.io.*;
import java.util.*;
/* 
    서강근육맨
*/
public class BOJ20300 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        long max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }   

        Arrays.sort(arr);

        int j = n-1;
        if (n%2 != 0) {            
            max = arr[j];            
            j--;
        }

        for(int i = 0; i<n/2; i++){
            max = Math.max(max, arr[i]+arr[j-i]);
        }

        System.out.println(max);        

    }
}
