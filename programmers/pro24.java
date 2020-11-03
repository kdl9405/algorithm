
import java.util.Arrays;

public class pro24 {

    public static void main(String[] args) {

        int[] people = { 40,40,40,50,50,60 };

        System.out.println(solution(people, 100));
    }

    static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int i = 1;
        int length = people.length;
        int n = 0;

        while (true) {

            if(i>length ||  people[length-i] == 0){
                break;
            }

            int reserve = limit - people[length - i];
            people[length - 1] = 0;

            for (int j = n; j < length - i; j++) {

                if (people[j] == 0) {
                    continue;
                }else if (people[j] <= reserve) {
                    reserve = reserve - people[j];
                    people[j] = 0;
                    n = j+1;
                }else {
                    break;
                }
            }

            answer++;
            i++;
        }

        return answer;
    }
}
