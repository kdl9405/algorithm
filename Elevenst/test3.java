package Elevenst;

import java.util.*;

public class test3 {

    public static void main(String[] args) {

        int[] A = new int[200000];

        Arrays.fill(A, 1);

        System.out.println(solution(A));

    }

    static int solution(int[] A) {
        int answer = 0;
       
        Arrays.sort(A);

       
        for(int i = 0; i<A.length; i++){
            answer += Math.abs(A[i]-(i+1)); 
        }

        return answer;
    }

}
