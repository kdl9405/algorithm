package kakao;

import java.io.*;
import java.util.*;


public class pro1 {

    public static void main(String[] args) {

        int[] gift_cards = {1,1,2,3,4};
        
        int[] wants = {2,2,2,2,2};

        // Arrays.fill(gift_cards, 1);
        // Arrays.fill(wants, 2);

        System.out.println(solution(gift_cards, wants));
        
    }

    public static int solution(int[] gift_cards, int[] wants) {

        int answer = 0;
        
        HashMap<Integer, Integer> gift = new HashMap<>();
        for(int card : gift_cards){
            gift.put(card, gift.getOrDefault(card, 0)+1);
        }        

        for(int want : wants){
            if (gift.containsKey(want)) {
                if (gift.get(want) > 1) {
                    gift.put(want, gift.get(want)-1);
                }else{
                    gift.remove(want);
                }
            }else{
                answer++;
            }
        }        
        
        return answer;
    }
}
    
