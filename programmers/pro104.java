/**
 * 기지국 설치
 */
public class pro104 {

    public static void main(String[] args) {

        int n = 16;
        int[] stations = {9};
        int w = 2;
        
        System.out.println(solution(n, stations, w));
    }
    static int solution(int n, int[] stations, int w) {
        int answer = 0;

        int from = 1;
        int to = 1;

        for(int i = 0; i<stations.length; i++){
            to = stations[i]-w;

            if (to > from) {
                int dif = to - from;
                int count = dif/((2*w)+1);
                if (dif%((2*w)+1) != 0) {
                    count++;
                }
                answer+=count;
            }
            from = stations[i]+w+1;

            if (i == stations.length-1) {
                if (from <= n) {
                    int dif = n - from +1;
                    int count = dif/((2*w)+1);
                    if (dif%((2*w)+1) != 0) {
                        count++;
                    }
                    answer+=count;  
                }
            }
        }

        return answer;
    }
}