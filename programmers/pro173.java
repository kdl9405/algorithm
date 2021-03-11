package programmers;

import java.util.*;

/* 
    단어 변환

*/
public class pro173 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        visit = new boolean[words.length];
        
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        
        boolean possible =false;
        
        loop:
        while(true){
            
            HashSet<String> set = new HashSet<>();
            
            answer++;
            while(!queue.isEmpty()){
                
                 String s = queue.poll();            
            
                for(int i = 0; i<words.length; i++){
                    if(!visit[i] && check(s, words[i])){
                        if(words[i].equals(target)){
                            possible = true;
                            break loop;
                        }
                        visit[i] = true;
                        set.add(words[i]);
                    }
                }
            }
            
            if(set.isEmpty()){
                break;
            }
           
            queue.addAll(set);
           
            
        }
        
        if(!possible){
            answer = 0;
        }
        
        return answer;
    }
    
    static boolean[] visit;
    
    static boolean check(String x, String y){
        int count = 0;
        for(int i = 0; i<x.length(); i++){
            if(x.charAt(i) != y.charAt(i)){
                count++;
            }if(count > 1){
                return false;
            }
        }
        return true;
    }
}
}
