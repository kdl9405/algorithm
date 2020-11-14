import java.util.*;

public class elel2 {
    public static void main(String[] args) {
        int[] A = {10,2,5,1,8,20};
        System.out.println(solution(A));

        int p = 100000000;
        int q = p-1;
        int r = p-1;
        int n = p+q+r;
        System.out.println(n);
    }
    static int solution(int[] A) {
        int answer = -1;

        if (A.length < 3) {
            return answer;
        }

        Arrays.sort(A);

      
        for(int i = 0; i<A.length-2; i++){
            int x = A[i] + A[i+1];
            
            for(int j = A.length-1; j>i+1; j--){
                if (x > A[j]) {
                    answer = Math.max(answer, (x + A[j]));
                    break;
                }
            }
        }

        return answer;
    }
}

