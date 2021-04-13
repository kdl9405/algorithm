package BOJ;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* 
    알바생 강호
*/
public class BOJ1758 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());

        Integer[] arr = new Integer[n];

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        long sum = 0;

        for(int i = 0; i<arr.length; i++){
            if (arr[i] - i <= 0) {
                break;
            }
            sum += (arr[i]-i);
        }
        
        System.out.println(sum);

    }
}
