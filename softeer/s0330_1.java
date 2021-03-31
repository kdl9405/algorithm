package softeer;

import java.util.*;
import java.io.*;

public class s0330_1 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long P = (long)Math.pow(10,8);
        long N = (long)Math.pow(10,6);

        long total = 0;

        long[] a = new long[(int)N];
        Arrays.fill(a, P);

        while (N-- > 0) {
            total *= 3;
            total %= 1000000007;
            total += a[(int)N];
            total %= 1000000007;
        }

        System.out.println(total);
    }
}
