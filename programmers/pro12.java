
import java.util.PriorityQueue;

// 더 맵게
public class pro12 {
    
    public static void main(String[] args) {
        
    }

    static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int val : scoville){
            pq.offer(val);
        }

        while (pq.peek() < K) {
            if (pq.size() == 1) {
                return -1;
            }

            int a = pq.poll();
            int b = pq.poll();

            pq.offer(a + b*2);
            answer++;
        }

        return answer;
    }
}

