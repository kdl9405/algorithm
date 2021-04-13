
import java.util.ArrayList;
//기능개발
public class pro9 {

    public static void main(String[] args) {

        int[] progresses = { 95, 90, 99, 99, 80, 99 };
        int[] speeds = { 1, 1, 1, 1, 1, 1 };

        solution(progresses, speeds);
    }

    public static OBOJect[] solution(int[] progresses, int[] speeds) {
        OBOJect[] answer;

        ArrayList<Integer> array = new ArrayList<>();

        int n = 0;

        while (true) {

            if (n >= progresses.length) {
                break;
            } else if (n == progresses.length - 1) {
                array.add(1);
                break;
            } else {
                int d = (100 - progresses[n]) / speeds[n];
                if (!((100 - progresses[0]) % speeds[0] == 0)) {
                    d++;
                }

                for(int i = n+1; i<progresses.length;i++){
                    progresses[i] = progresses[i] + speeds[i]*d;
                    
                }

                int count = 1;

                for(int i = n+1; i<progresses.length;i++){
                    
                    if (progresses[i] >= 100) {
                        count++;
                    } else {
                        break;
                    }
                }
                
                array.add(count);

                n = n + count;
            }


        }

        answer = array.toArray();

        for(int i = 0; i<answer.length;i++){
            System.out.println(answer[i]);
        }

        return answer;
    }

}