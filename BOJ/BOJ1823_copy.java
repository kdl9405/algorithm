package BOJ;

import java.io.*;
import java.util.*;

/* 
    수확 

    시간초과
*/

public class BOJ1823_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        max = 0;
        sum = new int[n + 1];

        bottomUp(1, 1, n);

        System.out.println(max);
    }

    static int[] arr;   
    static int[] sum;
    static int max;

    static void bottomUp(int index, int left, int right){
        if (left == right) {
            int t = 0;
            for(int i = 1; i<sum.length-1; i++){
                t +=(i*sum[i]);
            }
            t += (index*arr[left]);
            max = Math.max(max, t);
            return; 
        }       

        sum[index] = arr[left];
        bottomUp(index+1, left+1, right);

        sum[index] = arr[right];
        bottomUp(index+1, left, right-1);
    }

}
