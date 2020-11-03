/**
 * 풍선 터트리기
    시간초과
 */
public class pro81_copy {

    public static void main(String[] args) {

        int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};	
        System.out.println(solution(a));
        
    }

    static int solution(int[] a) {
        int answer = 0;

        for(int i = 0; i<a.length; i++){

            int count = 0;
            for(int j = 0; j<a.length; j++){
                
                if (i == j) {
                    continue;
                }
                if(j < i && a[j] < a[i]){
                    j = i-1;
                    count++;
                    continue;
                }
                if (j > 1 && a[j] < a[i]){
                    count++;
                    break;                   
                }
            }
            if (count <2) {
                answer++;
            }   
        }

        return answer;
    }
}