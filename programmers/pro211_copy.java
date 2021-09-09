package programmers;

import java.util.*;

/* 
    다단계 칫솔 판매

    테스트 케이스 실패

*/
public class pro211_copy {
    public static void main(String[] args) {

    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        child = new HashMap<>();
        for(int i = 0; i<referral.length; i++){
            if(!child.containsKey(referral[i])){
                child.put(referral[i], new HashSet<>());
            }
            
            child.get(referral[i]).add(enroll[i]);
        }
        
        income = new HashMap<>();
        for(int i = 0; i<seller.length; i++){
            income.put(seller[i], amount[i]*100);
        }
        
        getMoney("-");
        
        for(int i = 0; i<answer.length; i++){
            answer[i] =  income.get(enroll[i]);
        }
        
        return answer;
    }
    
    static HashMap<String, HashSet<String>> child;
    static HashMap<String, Integer> income;
    
    static int getMoney(String parent){
        
        int money = 0;
        if(income.containsKey(parent)){
            money = income.get(parent);
        }
        
        if(child.containsKey(parent)){
            for(String child : child.get(parent)){
            money +=(getMoney(child));
            }
        }
        
        if(parent.equals("-")){
            income.put(parent, money);
            return money;
        }
        
        income.put(parent, money-(money/10));
            
        return money/10;
    }
    
}
