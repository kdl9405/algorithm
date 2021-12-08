package BOJ;

/* 
    쉽게 푸는 문제

*/

import java.io.*;
import java.util.*;

public class BOJ1292 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

       
        int n = 1;
        int sum = 0;
        int idx = 0;
      
        loop:
        while (true) {

            for(int i = 0; i<n; i++){
                idx++;
                sum += n;
                if (idx == A) {
                    sum = n;
                }
                if(idx == B){
                    break loop;
                }
            }
            n++;
        }

        System.out.println(sum);

    }
}
