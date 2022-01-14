package BOJ;

/* 
    문자열
*/

import java.io.*;

public class BOJ1120 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int min = str[1].length();

        int dif = str[1].length() - str[0].length();
        for (int i = 0; i <= dif; i++) {

            int count = 0;
            for (int j = 0; j < str[0].length(); j++) {
                if (str[0].charAt(j) != str[1].charAt(j+i)) {
                    count++;
                }
            }
            min = Math.min(min, count);
        }

        System.out.println(min);
    }
}
