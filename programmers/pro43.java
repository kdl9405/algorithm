package programmers;

import java.util.*;

public class pro43 {
    public static void main(String[] args) {

        int[] arr = {2, 36, 1, 3};

        int[] result = solution(arr, 2);

        for(int i : result){
            System.out.print(i+" ");
        }
    }

    static int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        List<Integer> list = new LinkedList<>();
        
        for(int i = 0; i<arr.length; i++){
            if (arr[i] % divisor ==0) {
                list.add(arr[i]);
            }
        }

        if (list.isEmpty()) {
            list.add(-1);
        }
        answer = list.stream().mapToInt(i->i).toArray();
        
        Arrays.sort(answer);

        return answer;
    }
}
