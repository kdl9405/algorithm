package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
    우체국
*/
public class BJ2141 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n][2];

        long total = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());            
            total += arr[i][1];
        }
        
        Arrays.sort(arr, (a1,a2)->{
            return (int) (a1[0] - a2[0]);
        });


        long count = 0;
        long minPoint = 0;

        for(int i = 0; i<n; i++){
            count += arr[i][1];
            if (count >= (total+1)/2) {
                minPoint = arr[i][0];
                break;
            }
        }

        System.out.println(minPoint);      

    }
}
