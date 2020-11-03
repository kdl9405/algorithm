
import java.util.ArrayList;

// 모의고사
public class pro18 {
    
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};

        solution(answers);
    }

    static int[] solution(int[] answers) {
        int[] answer = {};

        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};

        int[] count = new int[3];

        for(int i = 0; i<answers.length; i++){

            if (answers[i] == a[i%5]) {
                count[0]++;
            }
            if (answers[i] == b[i%8]) {
                count[1]++;
            }
            if (answers[i] == c[i%10]) {
                count[2]++;
            }
        }

        ArrayList<Integer> person = new ArrayList<>();

        int max = Math.max(count[0], count[1]);
        max = Math.max(max, count[2]);

        for(int i = 0; i<count.length; i++){
            if (count[i] == max) {
                person.add(i+1);
            }
        }

        answer = new int[person.size()];

        for(int i =0; i<person.size();i++){
            answer[i] = person.get(i);
        }

        return answer;
    }
}
