package BOJ;

/* 
    수 이어 쓰기

*/

import java.io.*;

public class BOJ1515 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String num = "";
        int n = 0;

        int index = 0;

        loop:
        while (true) {

            n++;
            num = Integer.toString(n);

            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) == s.charAt(index)) {
                    index++;
                }
                if (index == s.length()) {
                    break loop;
                }
            }
           

        }

        System.out.println(n);

    }

}
