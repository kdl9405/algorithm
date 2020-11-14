/**
 * task3
 */
public class task2 {

    public static void main(String[] args) {

        int[] A ={3, 8, 9, 7, 6};
        int K = 3;

        solution(A, K);
    }

    static int[] solution(int[] A, int K) {

        if (A.length == 0 || K == 0)  {
            return A;
        }

        int[] answer = new int[A.length];

        K %= A.length;

        if (K < 0) {
            K = A.length-K;
        }


        for(int i = 0; i<A.length; i++){
            if (i + K <= answer.length-1) {
                answer[i+K] = A[i];
            }else{
                answer[(i+K)%A.length] = A[i];
            }
        }


        return answer;
    }
}
