package BOJ;

import java.io.*;
import java.util.*;

/**
 * 오븐 시계
 */
public class BOJ2525 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken()) + Integer.parseInt(br.readLine());

        A += (B / 60);
        
        A %= 24;
        B %= 60;

        System.out.println(A + " " + B);

    }

}