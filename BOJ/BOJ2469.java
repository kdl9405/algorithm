package BOJ;

import java.io.*;
import java.util.*;

/* 
    사다리타기

     
        55%


        copy_2 = 성공
    
*/

public class BOJ2469 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        char[] result = br.readLine().toCharArray();

        char[] position = new char[k];

        for (int i = 0; i < k; i++) {
            position[i] = (char) ('A' + i);
        }

        int index = 0;

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();

            if (line[0] == '?') {
                index = i;
                break;
            }

            for (int j = 0; j < k - 1; j++) {
                if (line[j] == '-') {
                    char temp = position[j];
                    position[j] = position[j + 1];
                    position[j + 1] = temp;

                }
            }
        }

        List<char[]> list = new ArrayList<>();
        for (int i = index + 1; i < n; i++) {
            list.add(br.readLine().toCharArray());
        }

        System.out.println(list.size());

        for (int i = list.size() - 1; i >= 0; i--) {

            char[] line = list.get(i);

            for (int j = 0; j < k - 1; j++) {
                if (line[j] == '-') {
                    char temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k - 1; i++) {
            if (position[i] == result[i]) {
                sb.append('*');
            } else if (position[i] == result[i + 1] && position[i+1] == result[i]) {
                sb.append('-');

                char temp = position[i];
                    position[i] = position[i + 1];
                    position[i + 1] = temp;

            } else {

                sb = new StringBuilder();
                for (int j = 0; j < k - 1; j++) {
                    sb.append("x");
                }
            }
        }

        System.out.println(sb.toString());

    }

    static int k, n;

}
