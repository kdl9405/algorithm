package programmers.dev2110;

import java.util.*;

/**
 * sol1
 */
public class sol1 {

    public static void main(String[] args) {
        
    }


    public static String solution(String[] registered_list, String new_id) {
        String answer = "";
               
        HashSet<String> registered = new HashSet<>();
        for(String r : registered_list){
            registered.add(r);
        }

        if (!registered.contains(new_id)) {
            answer = new_id;
        }else{

            String S = new_id.replaceAll("[0-9]", "");
            int N = 0;

            if (new_id.length() != S.length()) {
                N = Integer.parseInt(new_id.replaceAll("[^0-9]", ""));
            }

            while (true) {
                N++;
                
                if (!registered.contains(S+N)) {
                    answer = S+N;
                    break;
                }
            }          

        }

        
        return answer;
    }
}