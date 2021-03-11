package programmers;


import java.util.*;
/* 
    이중우선순위큐
*/
public class pro171 {
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
     
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String o : operations){
            String[] str = o.split(" ");
            if(str[0].equals("I")){
               int n = Integer.parseInt(str[1]);
                maxHeap.add(n);
                minHeap.add(n);
            }else{
                if(maxHeap.isEmpty()){
                    continue;
                }
                if(str[1].equals("1")){                    
                    minHeap.remove(maxHeap.poll());
                }else{
                    maxHeap.remove(minHeap.poll());
                }
            }
        }
        
        if(!maxHeap.isEmpty()){
              answer[0] = maxHeap.poll();
              answer[1] = minHeap.poll();
        }          
      
        
        return answer;
    }
}
