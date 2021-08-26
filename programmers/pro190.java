package programmers;

import java.util.*;

/* 
    직업군 추천하기
*/
public class pro190 {
    
    public static void main(String[] args) {

        String a = "SI";
        String b = "P";

        System.out.println(b.compareTo(a));
        

    }

    public static String solution(String[] table, String[] languages, int[] preference) {

        String answer = "";

        HashMap<String, Integer> languagePrefer = new HashMap<>();

        for(int i = 0; i<languages.length; i++){
            languagePrefer.put(languages[i], preference[i]);
        }

        int max = 0;
        

        for(String job : table){

            String[] detail = job.split(" ");

            int point = 0;

            for(int i = 1; i<=5; i++){
                if (languagePrefer.containsKey(detail[i])) {
                    point += ((6-i)*languagePrefer.get(detail[i]));
                }
            }

            if (point > max) {
               max = point;
               answer = detail[0];
            }else if(point == max){
                if (answer.compareTo(detail[0])>0) {
                    answer = detail[0];
                }
            }

        }

        return answer;
        
    }

   
    
}
