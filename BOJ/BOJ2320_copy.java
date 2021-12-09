package BOJ;

/* 
    끝말잇기 

    시간초과
*/

import java.io.*;
import java.util.*;

public class BOJ2320_copy {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
      
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for(int i = 0; i<N; i++){
            words[i] = br.readLine();
        }

        max = 0;
        sol('A', 1<<(N+2), 0);
        sol('E', 1<<(N+2), 0);
        sol('I', 1<<(N+2), 0);
        sol('O', 1<<(N+2), 0);
        sol('U', 1<<(N+2), 0);


        System.out.println(max);
    }

    static int N;
    static String[] words;
    static int max;

    static void sol(char c, int check, int len){

        for(int i = 0; i<N; i++){
            
            if ((check &(1<<i)) == (1<<i)) {
                continue;
            }

            if (c != words[i].charAt(0)) {
                continue;
            }
            
            sol(words[i].charAt(words[i].length()-1), check ^(1<<i), len+words[i].length());
            max = Math.max(max, len+words[i].length());
        }

        
    }
    
}
