package programmers;

/**
 * 줄 서는 방법

 */
public class pro98 {

    public static void main(String[] args) {

        System.out.println(solution(4, 6));

    }

    static int[] solution(int n, long k) {
        int[] answer = new int[n];

        fac = new long[n + 1];
        fac[0] = 1;
        long f = findFac(n);
        long count = k;

        boolean[] visit = new boolean[n + 1];
        visit[0] = true;

        int i = 0;
        while (i < n) {

            long x = fac[n-i-1];
           
            long t = 0;

            for(int j = 1; j<=fac[n-i]/x; j++){
                if (count>((j-1)*x) && count<=(x*j)) {
                    t = j;
                    break;
                }
            }

            count -= (t-1)*x;

            System.out.println("x = "+x+"   t = "+t+"   count = "+count);

            int c = 0;
            for (int j = 1; j <= n; j++) {
                if (!visit[j]) {
                    c++;
                }
                if (c == t) {
                    visit[j] = true;
                    answer[i] = j;
                    break;
                }
            }

            

            System.out.println(answer[i] +" ");


            i++;
        }

        return answer;
    }

    static long[] fac;

    static long findFac(int n) {
        if (fac[n] != 0) {
            return fac[n];
        }

        fac[n] = findFac(n - 1) * n;

        return fac[n];
    }

}