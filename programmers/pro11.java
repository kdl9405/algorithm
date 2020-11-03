
import java.util.*;

// 프린터
public class pro11 {

    public static void main(String[] args) {

        int[] priorities = { 2, 1, 3, 2 };

        int result = solution(priorities, 2);

        System.out.println(result);

    }

    static int solution(int[] priorities, int location) {

        int answer = 0;

        int[] temp_list = new int[priorities.length];
        for (int i = 0; i < priorities.length; i++) {
            temp_list[i] = priorities[i];
        }

        Arrays.sort(temp_list);
        int max = temp_list[temp_list.length - 1];

        int index = 0;

        for (int i = 0; i < priorities.length; i++) {
            if (priorities[i] == max) {
                index = i;

                break;
            }
        }

        int count = 0;

        while (true) {


            if (priorities[index] == max) {

                count++;
                System.out.println("count " + count);

                if (index == location) {
                    break;
                } else {
                    priorities[index] = 0;
                    temp_list[temp_list.length - 1] = 0;

                    Arrays.sort(temp_list);

                    for (int i = 0; i < temp_list.length; i++) {
                    }
                    max = temp_list[temp_list.length - 1];
                }
            }

            index++;
            if (index == priorities.length) {
                index = 0;
            }

        }

        answer = count;

        return answer;
    }

}
