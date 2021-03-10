package programmers;


import java.util.*;
/* 
    스타 수열

*/
public class pro167 {
    
    public int solution(int[] a) {
        int answer = 0;
        
        if(a.length < 2){
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int b : a){
            map.put(b, map.getOrDefault(b,0)+1);
        }
        
       for(int n : map.keySet()){
           if(map.get(n)*2 < answer){
               continue;
           }
           int count = 0;
           for(int i = 0; i<a.length-1; i++){
               if(a[i] == n || a[i+1] == n ){
                   if(a[i] != a[i+1]){
                       count+=2;
                        i++;
                   }
               }
           }
           answer = Math.max(answer, count);
       }
               
        
        return answer;
    }
}
