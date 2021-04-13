package programmers;

/* 
    선입 선출 스케줄링

    findCount(n)으로 시간이 n일때 처리된 일의 수량을 표현하고, 이분탐색으로 n을 검색?
*/

public class pro180 {
    public static void main(String[] args) {

        int n = 6;
        int[] cores = { 1, 2, 3 };

        System.out.println(solution(n, cores));
    }


    public static int solution(int n, int[] cores) {
        int answer = 0;

        int min = 0;
        int max = cores[0]*n;

        int time = 0;
        int m = 0;

        while (min <= max) {
            int mid = (min+max)/2;

            int count = findCount(mid, cores);

            if (count >= n) {
                max = mid-1;   
                time = mid;     
                m = count; 
            }else{
                min = mid+1;
            }
        }

        m-=n;
        for(int i = cores.length-1; i>=0; i--){
            if (time % cores[i] == 0) {
                if (m == 0) {
                    answer = i+1;
                    break;
                }
                m--;
            }
        }

        return answer;
    }

    static int  findCount(int time, int[] cores){

        if (time == 0) {
            return cores.length;
        }

        int count = cores.length;

        for(int i = 0; i<cores.length; i++){
            count += (time/cores[i]);
        }

        return count;
    }
}
