package BOJ;

import java.io.*;
import java.util.Arrays;

/* 
    락스타 락동호
*/

public class BOJ1581 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int s = num[0] + num[1] + num[2] + num[3];
        int c = num[0] * num[1] * num[2] * num[3] - 1;

        System.out.println(s*c);

    }

}
