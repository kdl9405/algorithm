package Elevenst;

import java.util.*;

public class test2 {

    public static void main(String[] args) {

        String[] S = { "zzzz", "ferz", "zdsr" };

        int[] answer = solution(S);

        System.out.println(answer);
    }

    static int[] solution(String[] S) {
        int[] answer = new int[3];
        int n = S.length;
        int m = S[0].length();

        int[][] alphabet = new int[26][2];
        boolean check = false;

        int i = 0;
        int j = 0;
        loop: for (i = 0; i < m; i++) {

            alphabet = new int[26][2];

            for (j = 0; j < n; j++) {
                if (alphabet[S[j].charAt(i) - 'a'][0] == 0) {
                    alphabet[S[j].charAt(i) - 'a'][0] = j + 1;
                } else {
                    alphabet[S[j].charAt(i) - 'a'][1] = j;
                    check = true;
                    break loop;
                }

            }
        }

        if (check) {
            answer[0] = alphabet[S[j].charAt(i) - 'a'][0] - 1;
            answer[1] = alphabet[S[j].charAt(i) - 'a'][1];
            answer[2] = i;
        } else {
            answer[0] = (Integer) null;
            answer[1] = (Integer) null;
            answer[2] = (Integer) null;
        }

        int[] test= new int[3];
        test[0] = 0;
        test[1] =  0;
        test[2] =0;

        int[] t = {};
        
       
        return t;
    }
}
