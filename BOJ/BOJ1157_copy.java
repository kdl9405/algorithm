package BOJ;

import java.io.*;

/**
 * BOJ1157
 */
public class BOJ1157_copy {
    public static void main(final String[] args) throws IOException {
        // A-a = 32 , A = 65, Z=90

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine().toUpperCase();

        int[] alphabet = new int[26];

        for(char c : S.toCharArray()){
            alphabet[c-'A']++;
        }

        int max = 0;
        char c = '?';

        for(int i = 0; i<26; i++){
            if (alphabet[i] > max) {
                max = alphabet[i];
                c = (char)(i+'A');
            }else if(alphabet[i] == max){
                c = '?';
            }
        }

        System.out.println(c);
    }
}