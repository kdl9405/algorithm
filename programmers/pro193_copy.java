package programmers;

import java.util.*;


/*
    모음 사전
*/


public class pro193_copy {
    
    public static void main(String[] args) {

        System.out.println(solution("I"));
    }

    public static int solution(String word) {
        int answer = 0;

        alphabet = new char[] {'A','E','I','O','U'};

        temp = new char[5];
        list = new LinkedList<>();

        dfs(0);

        for(int i = 0; i<list.size(); i++){
            if (word.equals(list.get(i))) {
                answer = i+1;
                break;
            }
        }
        
        return answer;
    }

    static char[] alphabet;
    static List<String> dictionary;
    static char[] temp;
    static List<String> list;



    static void dfs(int depth){

        if (depth == 5) {
            return;
        }

        for(int i = 0; i<5; i++){
            temp[depth] = alphabet[i];

            String s = (new String(temp)).substring(0,depth+1);
            list.add(s);

            dfs(depth+1);
            
        }

    }
}