package BOJ;

import java.io.*;

/* 
    알파벳 개수
*/

public class BOJ10808{

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alphabet = new int[26];

        String s = br.readLine();
        for(int i= 0; i<s.length(); i++){
            alphabet[s.charAt(i)-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int a : alphabet){
            sb.append(a+" ");
        }

        System.out.println(sb.toString().trim());

    }
}