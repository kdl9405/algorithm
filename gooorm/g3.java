package gooorm;

import java.io.*;
import java.util.*;

/* 
    대소문자 바꿔서 출력하기
*/
public class g3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            if (Character.isUpperCase(input[i])) {
                input[i] = Character.toLowerCase(input[i]);
            } else {
                input[i] = Character.toUpperCase(input[i]);
            }
        }

        System.out.println(new String(input));
    }
}