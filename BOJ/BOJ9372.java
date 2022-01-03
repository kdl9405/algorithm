package BOJ;

import java.io.*;
import java.util.*;

/* 
    상근이의 여행
*/

public class BOJ9372 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for (int j = 0; j<M; j++) {
                br.readLine();
            }

            sb.append(N-1).append("\n");

        }
		
		System.out.println(sb.toString());
    }
}
