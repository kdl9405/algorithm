package BJ;

import java.io.*;
import java.util.*;

/* 
    크게 만들기
    메모리초과
*/
public class BJ2812_copy {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String num = br.readLine();

        while (k-- > 0) {

            for (int i = 0; i < 10; i++) {

                if (num.charAt(0) == (char)(i+'0')  && num.charAt(1) == 0) {
                    num.replaceFirst(Integer.toString(i), "Z");
                }

                if (num.contains(Integer.toString(i))) {
                    num = num.replaceFirst(Integer.toString(i), "");
                    num = num.replaceFirst("Z", Integer.toString(i));
                    break;                    
                }               

                if (num.charAt(0) == 'Z') {
                    num = num.replaceFirst("Z", Integer.toString(i));
                }
            }
        }

        System.out.println(num);

    }
}
