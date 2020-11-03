package programmers;

import java.util.*;

/**
 * 폰켓몬
 */
public class pro55 {

    public static void main(String[] args) {
        
        int[] nums = {3,3,3,2,2,2};

        System.out.println(solution(nums));
    }

    static int solution(int[] nums) {
        int answer = 0;

        HashSet<Integer> hash = new HashSet<>();

        for(int n : nums){
            hash.add(n);
        }

        if (hash.size() > nums.length/2) {
            answer = nums.length/2;
        }else{
            answer = hash.size();
        }

        return answer;
    }
}
