import java.util.Arrays;

/**
 * 숫자 게임
 * 
 */
public class pro105 {

    public static void main(String[] args) {

        int[] A = { 2,3,4,5,6,7 };
        int[] B = { 3,4,5,6,7,2};

        System.out.println(solution(A, B));

    }

    static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);        
        Arrays.sort(B);

        int i = 0;
        int j = 0;

        while (i<A.length && j<B.length) {
            int a = A[i];
            int b = B[j];
            if (a>=b) {
                while (a>=b) {
                    j++;
                    if (j >= B.length) {
                        break;
                    }
                    b = B[j];
                }
            }
            if (a < b) {
                answer++;
            }

            i++;
            j++;

        }
        

        return answer;
    }
}