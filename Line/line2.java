import java.util.*;

public class line2 {

    public static void main(String[] args) {

        int[] ball = { 11, 2, 9, 13, 24 };
        int[] order = { 9, 2, 13, 24, 11 };

        int[] answer = solution(ball, order);

        for(int i = 0; i<answer.length; i++){
            System.out.println(answer[i]);
        }

    }

    static int[] solution(int[] ball, int[] order) {
        int[] answer = new int[order.length];

        Queue<Integer> leftQ = new LinkedList<>();
        Queue<Integer> rightQ = new LinkedList<>();

        for (int i = 0; i < ball.length; i++) {
            leftQ.offer(ball[i]);
        }
        for (int i = ball.length - 1; i >= 0; i--) {
            rightQ.offer(ball[i]);
        }

        List<Integer> reserve = new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < order.length; i++) {

            if (reserve.size() != 0) {

                for(int n = 0; n< reserve.size(); n++){

                    for (int j = 0; j < reserve.size(); j++) {

                        if (leftQ.peek() == reserve.get(j)) {
                            result.add(reserve.get(j));
                            rightQ.remove(leftQ.poll());
                          
                        } else if (rightQ.peek() == reserve.get(j)) {
                            result.add(reserve.get(j));
                            leftQ.remove(rightQ.poll());
                            
                        }
                    }

                }              
                    
                    
                }            

            if (leftQ.peek() == order[i]) {
                result.add(order[i]);
                rightQ.remove(leftQ.poll());
            } else if (rightQ.peek() == order[i]) {
                result.add(order[i]);
                leftQ.remove(rightQ.poll());
            } else {
                reserve.add(order[i]);
            }
        }

   
    for(int i = 0; i<answer.length; i++){
        answer[i] = result.get(i);
    }

    return answer;
}}
