package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
    문자열 폭발

    메모리 초과
*/
public class BOJ9935_copy {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String x = br.readLine();

        while (s.contains(x)) {
            s = s.replaceAll(x, "");
           
        }

        if (s.length()<1) {
            System.out.println("FRULA");
        }else{
            System.out.println(s);
        }

    }
}
