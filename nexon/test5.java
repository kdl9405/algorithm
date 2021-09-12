package nexon;

import java.util.*;

import javax.security.auth.x500.X500PrivateCredential;


public class test5 {

    public static void main(String[] args) {
        
        String s = "rrrlrr";

        int n = 7;
        int x = 0;
        int y = 0;

        System.out.println(distinctMoves(s, n, x, y));
    }
    

    public static int distinctMoves(String s, int n, int x, int y) {
        
        sequence = new HashMap<>();
        
        makeSuq(s, 0, new StringBuilder(), 0);

        System.out.println(sequence);
        
        int MOD = 1000000007;
        
        int answer = 0;

        for(String seq : sequence.keySet()){
            
            if (sequence.get(seq) == y) {
                answer++;
            }
            
            answer %= MOD;
            
            
        }        
        
        
        return answer;
        
    }
    
    static HashMap<String, Integer> sequence; 
    
    static void makeSuq(String s , int idx, StringBuilder sb, int x){
        
        sequence.put(sb.toString(), x);
        
        if (idx == s.length()) {
            return;
        }   
    
        makeSuq(s, idx+1, sb, x);

        if (s.charAt(idx) == 'r') {
            makeSuq(s, idx+1, new StringBuilder(sb).append(s.charAt(idx)), x+1);                
        }else{
            if (x > 0) {
                makeSuq(s, idx+1, new StringBuilder(sb).append(s.charAt(idx)), x-1);                
            }
        }
        
        
        
    }
}
