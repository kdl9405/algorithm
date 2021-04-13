package BOJ;

import java.io.*;
import java.util.*;

/* 
    홀수 홀릭 호석
*/

public class BOJ20164 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        devide(num, 0);

        System.out.println(min + " " + max);

    }

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    static void devide(String num, int count) { // 자릿수 중 홀수 더하고 분할
        int len = num.length();

        count += countFunc(num);
        
        if (len == 1) {            
            min = Math.min(count, min);
            max = Math.max(count, max);

            return;
        }

        if (len == 2) {       
           int n = Integer.parseInt(num);
           devide(String.valueOf((n/10)+(n%10)), count);      
        }

        if (len > 2) {
            for (int i = 0; i < len - 2; i++) {
                for (int j = i + 1; j < len - 1; j++) {
                    String a = num.substring(0, i + 1);
                    String b = num.substring(i + 1, j + 1);
                    String c = num.substring(j + 1);

                    int n = Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c);
                    devide(Integer.toString(n), count);
                }
            }
        }

    }

    static int countFunc(String num) {
        int c = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) % 2 == 1) {
                c++;
            }
        }

        return c;
    }

}
