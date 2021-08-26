package programmers;

import java.util.*;

/* 
    직업군 추천하기
*/
public class pro190_copy {
    
    public static void main(String[] args) {
        

    }

    public static String solution(String[] table, String[] languages, int[] preference) {

        HashMap<String, Integer> languagePrefer = new HashMap<>();

        for(int i = 0; i<languages.length; i++){
            languagePrefer.put(languages[i], preference[i]);
        }

        
        List<result> list = new LinkedList<>();

        for(String job : table){

            String[] detail = job.split(" ");

            int point = 0;

            for(int i = 1; i<=5; i++){
                if (languagePrefer.containsKey(detail[i])) {
                    point += ((6-i)*languagePrefer.get(detail[i]));
                }
            }

            list.add(new result(detail[0], point));
        }
        

        Collections.sort(list, (l1,l2)->{

            if (l1.point == l2.point) {
               return l1.title.compareTo(l2.title);
            }
          
            return l2.point - l1.point;
        });

        return list.get(0).title;
    }

   
    
}

class result {
    String title;
    int point;

    public result(String title, int point){
        this.title = title;
        this.point = point;
    }
}