package programmers;
import java.util.*;


/* 
    정수 내림차순으로 배치하기

*/
public class pro150 {

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String number = Long.toString(n);
        int[] arr= Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = arr.length-1; i>=0; i--){
            sb.append(arr[i]);
        }
        
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}
}
