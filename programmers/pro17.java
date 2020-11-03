
import java.util.Arrays;
import java.util.Comparator;

public class pro17 {

    public static void main(String[] args) {

        int[] citations = {0,0,0};

       System.out.println(solution(citations));  
    }

    static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {

            if (citations[citations.length-1-i] < i+1) {

                answer = i;

                
                break;
            }
            if (i == citations.length-1) {
                answer = citations.length;
            }
        }

        return answer;
    }
}