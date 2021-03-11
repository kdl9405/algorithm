
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

// 이중우선순위큐
public class pro14 {

    public static void main(String[] args) {

        String[] operations = { "I 7", "I 5", "I -5", "D -1" };

        int[] result = solution(operations);

        System.out.println(result[0]+" "+result[1]);

    }

    static int[] solution(String[] operations) {
        int[] answer = new int[2];

        int i = 0;

        PriorityQueue<Integer> Maxheap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> Minheap = new PriorityQueue<>();

        while (i < operations.length) {

            switch (operations[i]) {
                case "D 1":

                    if (!Maxheap.isEmpty()) {
                        Minheap.remove(Maxheap.poll());
                    }
                    break;

                case "D -1":

                    if (!Minheap.isEmpty()) {
                        Maxheap.remove(Minheap.poll());
                    }
                    break;

                default:

                    int n = Integer.parseInt(operations[i].replaceAll("I ", ""));

                    Maxheap.offer(n);
                    Minheap.offer(n);
                    break;

            }
            i++;
        }

        if (!Maxheap.isEmpty()) {
            answer[0] = Maxheap.poll();
            answer[1] = Minheap.poll();
        } else {
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }
}