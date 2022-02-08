package BOJ;

/* 
    문서 검색
 */

import java.io.*;

public class BOJ1543 {

    public static void main(String[] args) throws IOException {

        new BOJ1543().solution();
    }

    void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String document = br.readLine();
        String word = br.readLine();

        document = document.replaceAll(word, "*");

        int count = 0;
        for (int i = 0; i < document.length(); i++) {
            if (document.charAt(i) == '*') {
                count++;
            }
        }

        System.out.println(count);
    }
}
