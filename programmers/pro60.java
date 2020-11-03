import java.util.Arrays;

/**
 * 피보나치 수
 */
public class pro60 {

    public static void main(String[] args) {

        System.out.println(solution(5));

    }

    static int[] arr;

    static int solution(int n) {
        int answer = 0;

        arr = new int[n+1];

        Arrays.fill(arr, -1);

        arr[0] = 0;
        arr[1] = 1;
       
        answer = fivo(n);       

        return answer;

    }

    static int fivo(int n){
        
        if (arr[n] != -1) {
            return arr[n];
        }else{
            arr[n] = (fivo(n-1) + fivo(n-2)) % 1234567;
            return arr[n];
        }
    }
}
