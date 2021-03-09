package programmers;
import java.util.*;

/* 
    제일 작은 수 제거하기

*/
public class pro152 {
    public static void main(String[] args) {

        int[] arr = new int[]{2,1,4,5,7,3,1};
        
        int[] answer = solution(arr);
        for(int a : answer){
            System.out.print(a+" ");
        }
    }

    static public int[] solution(int[] arr) {
                       
        int[] answer = arr.clone();
        
        if(arr.length==1){
            answer = new int[]{-1};
        }else {
            Arrays.sort(answer);
            int min = answer[0];
            answer = new int[arr.length-1];
            int j = 0;
            boolean check = false;
            for(int i = 0; i<answer.length; i++){
                if(arr[j] == min && !check){
                    j++;
                    check = true;
                }
                answer[i] = arr[j];
                j++;
            }
        }
        
        return answer;
    }
}
