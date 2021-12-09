package BOJ;

/* 
    방 번호

*/

import java.io.*;
import java.util.*;

public class BOJ1475_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] num = br.readLine().toCharArray();

        HashMap<Integer, Integer> count = new HashMap<>();

        for (char n : num) {

            if (n == '9') {
                count.put(6, count.getOrDefault(6, 0) + 1);
            } else {
                count.put(n - '0', count.getOrDefault(n - '0', 0) + 1);
            }
        }

        if (count.containsKey(6)) {
            int c = count.get(6);

            if (c % 2 == 1) {
                c = c / 2 + 1;
            } else {
                c /= 2;
            }

            count.put(6, c);
        }

        int max = 0;

        for (int i = 0  ; i < 9; i++) {

            if (!count.containsKey(i)) {
                continue;
            }
            max = Math.max(max, count.get(i));
        }

        System.out.println(max);
    }
}
