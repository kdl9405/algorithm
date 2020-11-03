package programmers;

import java.util.*;

public class pro38 {
    
    public static void main(String[] args) {
        
        int[] numbers = {2,1,3,4,1};

        int[] result = solution(numbers);

        for(int i : result){
            System.out.print(i+" ");
        }
    }

    static int[] solution(int[] numbers) {
        int[] answer = {};

        HashSet<Integer> hash = new HashSet<>();

        for(int i = 0; i<numbers.length-1; i++){
            for(int j = i+1; j<numbers.length; j++){
                hash.add(numbers[i] + numbers[j]);
            }
        }

        answer = hash.stream().mapToInt(i->i).toArray();

        Arrays.sort(answer);

        return answer;
    }
}

