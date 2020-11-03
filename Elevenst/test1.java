package Elevenst;

import java.util.*;
import java.io.*;

public class test1 {

    public static void main(String[] args) {

        String s = "doga";

        System.out.println(Solution(s));
        
    }

    static int Solution(String s){
        
        if (s.contains("aaa")) {
            return -1;
        }

        int answer = (s.length()+1)*2;

        s = s.replaceAll("aa", "*");

        int count = 0;
        for(int i = 0; i<s.length(); i++){
            if (s.charAt(i) == '*') {
                count++;
            }
        }

        answer = answer-(count*6);        

        count = 0;
        for(int i = 0; i<s.length(); i++){
            if (s.charAt(i) == 'a') {
                count++;
            }
        }

        answer = answer-(count*3);


        
        return answer;

    }
    
}
