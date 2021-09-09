package programmers.month2109;

import java.util.*;

/* 

*/

public class sol1 {

    public static void main(String[] args) {
        
    }

    public int solution(int[] numbers) {
        int answer = 0;

        boolean[] num = new boolean[10];
        for(int n : numbers){
            num[n] = true;
        }

        for(int i = 0; i<10; i++){
            if (!num[i]) {
                answer+=i;
            }
        }

        return answer;
    }
    
}
