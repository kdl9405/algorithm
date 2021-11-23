package BOJ;

/* 
    배수와 약수
*/

import java.io.*;
import java.util.*;

public class BOJ5086 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) {
                break;
            }

            if (b%a == 0) {
                sb.append("factor");
            }else if(a%b == 0){
                sb.append("multiple");
            }else{
                sb.append("neither");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
