package BOJ;

import java.io.*;

/* 
    팩토리얼 0의 개수
*/
public class BOJ11687 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long m = Long.parseLong(br.readLine());

        long min = 0;
        long max = 5 * m;

        while (min <= max) {
            long mid = (min + max) / 2;

            long num = mid;
            int zero = 0;

            while (num >= 5 && zero <= m) {
                zero += (num / 5);
                num /= 5;
            }

            if (zero < m) {
                min = mid+1;
            }else{
                max = mid-1;
            }
        }

        long num = min;
        int zero = 0;
        while (num >= 5) {
            zero+=(num/5);
            num/=5;
        }

        if (zero == m) {
            System.out.println(min);
        }else{
            System.out.println(-1);
        }
    }
}