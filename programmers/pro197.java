package programmers;

import java.util.*;


/* 
    [3차] 압축



    1. 사전에 기본값 추가
    2. w 값 출력
    3. w+c 가 사전에 없으면 추가 / w = c
    4. w+c 가 사전에 있으면, /사전에 없는 것이 나올때까지 w+c;

*/

public class pro197 {
    

    public static void main(String[] args) {

        int[] answer =solution("ABABABABABABABAB");

        for(int a : answer){
            System.out.println(a);
        }
        
    }

    public static int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> dictionary = new HashMap<>();
        int x = 0;
        for(; x<26; x++){
            dictionary.put(Character.toString('A'+x), x+1);
        }
        x++;

        String w = Character.toString(msg.charAt(0));
        for(int i = 1; i<msg.length(); i++){
            
            answer.add(dictionary.get(w));

            String c = Character.toString(msg.charAt(i));

            System.out.println(w+" " +c +" "+ dictionary.get(w));


            if (!dictionary.containsKey(w+c)) {
                dictionary.put(w+c, x);
                x++;
                w = c;
            }

            while(true){
                i++;

                if (i>=msg.length()) {
                    break;
                } else {
                    
                }

                c = Character.toString(msg.charAt(i));

                if (!dictionary.containsKey(w+c)) {
                    i--;
                    break;
                }else{
                    w += c;
                }
            }

            System.out.println("w = " + w);

        }

        answer.add(dictionary.get(w));
     

        return answer.stream().mapToInt(i->i).toArray();
    }
}
