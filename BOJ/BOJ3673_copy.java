package BOJ;

import java.io.*;
import java.util.Arrays;

/* 
    나눌 수 있는 부분 수열

    // 시간초과
        
*/
public class BOJ3673_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (c-- > 0) {

            int[] option = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            long[] number = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            long sum = 0;
            for(int i = 0; i<option[1]; i++){

                sum+= number[i];
            }

            int count = 0;

            for(int i = 0; i<option[1]; i++){
                if (i>0) {
                    sum -= number[i-1];
                }

                long temp = sum;
                if (sum>=option[0] &&  sum % option[0] == 0) {
                    count++;
                }

                for(int j = option[1]-1; j>i; j--){
                    temp -= number[j];
                    if (temp < option[0]) {
                        break;
                    }
                    if (temp >= option[0] && temp % option[0] == 0) {
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb.toString().trim());

    }
}
