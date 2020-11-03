package programmers;

/**
 * 멀리 뛰기

 */
public class pro92 {

    
    public static void main(String[] args) {
        
        System.out.println(solution(3));
    }

    static long solution(int n) {
        long answer = 0;

        arr = new long[n+1][n+1];

        int one = n;
        int two = 0;

        
        for(int i = one; i>=0; i-=2){

            answer += findC(i+two, Math.min(i, two));
            two++;
        }
        


        return answer;
    }

    static long[][] arr; //조합 경우의 수

    static long findC(int n, int r){
        if (arr[n][r] != 0) {
            return arr[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }

        arr[n][r] = findC(n-1, r-1) + findC(n-1, r);

        return arr[n][r];
        
    }

}