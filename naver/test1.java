package naver;

import java.util.*;
import java.io.*;

public class test1 {

    public static void main(String[] args) {

        String m = "babadfbasdbasdgdsabdsgasdgdsfsdfsdfsdafwaefcbad";
        String k = "abfgiekdfsdf";

        System.out.println(Solution(m, k));
        
    }

    static String Solution(String m, String k){

        String answer = "";

        StringBuilder sb = new StringBuilder();

        String[] key = k.split("");

        int j = 0;

        int begin = 0;


        for(int i = 0; i< m.length(); i++){
            if (j<k.length() &&Character.toString(m.charAt(i)).equals(key[j])) {
                j++;               
                continue;
            }
            
            sb.append(m.charAt(i));
            
        }

        System.out.println(sb);

        // for(int i = 0; i< key.length; i++){
        //     answer = answer.replaceFirst(key[i], "");

        // }

answer = sb.toString();

        return answer;

    }
    
}
