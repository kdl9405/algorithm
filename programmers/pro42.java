package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class pro42 {
    
    public static void main(String[] args) {

        int[]arr = {1,1,3,3,0,1,1};

        int[] result = solution(arr);

        for(int i : result){
            System.out.println(i);
        }
        
    }

    static int[] solution(int []arr) {
        int[] answer = {};
        
        Deque<Integer> deque = new LinkedList<>();

        deque.add(arr[0]);

         for(int a : arr){
             if (deque.peekLast() != a) {
                 deque.offer(a);
             }
         }

         answer = deque.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}
