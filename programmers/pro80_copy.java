/**
 * 2 x n 타일링
 * ????실패 이유 모름....
 */
public class pro80_copy {

    public static void main(String[] args) {


        System.out.println(solution(52));

    }

    static int solution(int n) {
        int answer = 0;

        int x = 0; 
        int y = n/2;

        if(n % 2 == 1){
            x = 1;
        }

        long[] arr = new long[n+1];
        arr[0] = 1;
        for(int i =1; i<=n; i++){
            arr[i] = (arr[i-1] *i) % 1000000007;
            System.out.println(arr[i]);
        }

        while (y>=0) {

           answer += count(x, y,arr);
           answer %= 1000000007;
           x+=2;
           y--;


        }


        return answer;
    }

    static long count(int x, int y, long[] arr){
        int n = x+y;
        int r = Math.min(x, y);

        long result = (arr[n] / (arr[r] * arr[n-r])) % 1000000007;


        System.out.println(result);
        return result;



    }
}