import java.util.Arrays;

//징검다리
public class pro36 {
    
    public static void main(String[] args) {

        int[] rocks = {2,14,11,21,17};
        
        System.out.println(solution(25, rocks, 2));
    }

    static int solution(int distance, int[] rocks, int n) {
        
        Arrays.sort(rocks);
        
        int min = 1;
        int max = distance;
        int mid;
        int remove;
        int last;              
        int answer = 1;;

        while (min <= max) {
            mid = (min+max)/2;
            remove = 0;
            last = 0;

            for(int i = 0; i<rocks.length; i++){
                
                if (rocks[i] - last <mid) {
                    remove++;
                }else{
                    last = rocks[i];
                }                
            }
            if (distance - last < mid) {
                remove++;
            }

            if (remove > n) {
                max = mid -1;
            }else{
                answer = Math.max(answer, mid);
                min = mid+1;
            }
        }
        return answer;
    }
}
