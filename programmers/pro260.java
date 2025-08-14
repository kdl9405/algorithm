package programmers;

import java.util.Stack;

public class pro260 {

    public int solution(int[] order) {

        Stack<Integer> second = new Stack<>();

        int n = order.length;
        int boxNo = 1;

        int orderIndex = 0;
        int answer = 0;
        while (boxNo <= n) {

            while (!second.isEmpty() && second.peek() == order[orderIndex]) {
                second.pop();
                answer++;
                orderIndex++;
            }

            if (boxNo == order[orderIndex]) {
                answer++;
                orderIndex++;
            } else {
                second.add(boxNo);
            }
            boxNo++;
        }

        while (!second.isEmpty() && second.peek() == order[orderIndex]) {
            second.pop();
            answer++;
            orderIndex++;
        }

        return answer;
    }
}
