package BOJ;

import java.io.*;
import java.util.regex.Pattern;

/* 
    단어 개수 세기
*/

public class BOJ19844 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String[] arr = s.split("[- ]");

        int count = arr.length;

       Pattern p = Pattern.compile("^(c|j|n|m|t|s|l|d|qu)'[aeiouh]");
        for(String a : arr){
            if (p.matcher(a).find()) {
                count++;
            }
        }

        System.out.println(count);
    }
}
