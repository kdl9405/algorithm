package programmers;

import java.util.Arrays;

/**
 * 최솟값 만들기

 */
public class pro59 {

    
    public static void main(String[] args) {

        int [] A = {1,4,2};
        int [] B = {4,4,5};

        System.out.println(solution(A, B));
        
    }

    static int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        
        Arrays.sort(B);

        int last = A.length-1;

        for(int i = 0; i<=last; i++){
            answer += A[i]*B[last-i];
        }
       

        return answer;
    }
}