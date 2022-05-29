package BOJ;

/**
 * 주몽
 */

import java.io.*;
import java.util.*;

public class BOJ1940 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] meterial = new int[10000001];
        for (int i = 0; i < N; i++) {
            meterial[Integer.parseInt(st.nextToken())]++;
        }

        int answer = 0;
        for(int i = 1; i<M/2; i++){
            if (meterial[i] > 0) {
                answer+=(Math.min(meterial[i], meterial[M-i]));
           }
        }

        if(M % 2 == 0){
            answer += (meterial[M/2]/2); 
        }else{
            answer += Math.min(meterial[M/2], meterial[M/2+1]); 
        }

        System.out.println(answer);
    }

}