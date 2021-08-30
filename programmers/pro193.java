package programmers;

import java.util.*;


/*
    모음 사전
*/


public class pro193 {
    
    public static void main(String[] args) {

        System.out.println(solution("AAEIO"));
    }

    public static int solution(String word) {
        int answer = 0;

        alphabet = new char[] {'A','E','I','O','U'};

        temp = new char[5];
        list = new LinkedList<>();
        find = false;
        
        dfs(0, word);

        answer = list.size();
        
        return answer;
    }

    static char[] alphabet;
    static List<String> dictionary;
    static char[] temp;
    static List<String> list;
    static boolean find;



    static void dfs(int depth, String word){
        

        if (depth == 5) {
            return;
        }

        for(int i = 0; i<5; i++){

            if(find){
                break;
            }

            temp[depth] = alphabet[i];

            String s = (new String(temp)).substring(0,depth+1);
            list.add(s);

            if (word.equals(s)) {
                find = true;
               break; 
            } 

            dfs(depth+1, word);
            
        }

        return;

    }
}