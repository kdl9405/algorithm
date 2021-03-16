package softeer;

import java.io.*;
import java.util.*;
/* 
    바이러스
*/
public class one {
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long answer = (long)(Math.pow(p,n) % 1000000007);

        answer  = (answer * k) % 1000000007;

        System.out.println(answer);

    }
}