package BOJ;

/* 
    N번째 큰 수
*/

import java.io.*;
import java.util.*;

public class BOJ2693 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ2693().soulution();
    }

    void soulution() throws NumberFormatException, IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int[] num;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            num = new int[10];
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i<10; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(num);
            sb.append(num[7]).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
