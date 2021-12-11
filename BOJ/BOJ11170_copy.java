package BOJ;

/* 
    0의 개수
*/

import java.io.*;
import java.util.*;

public class BOJ11170_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- >0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int count = 0;

            while(N <= M){
                
                count += String.valueOf(N).replaceAll("[^0]", "").length();

                N++;
            }

            sb.append(count+"\n");
        }

        System.out.println(sb.toString().trim());

        
    }

}
