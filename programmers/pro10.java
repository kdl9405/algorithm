
import java.util.LinkedList;
import java.util.Queue;

// 다리를 지나는 트럭

public class pro10 {

    public static void main(String[] args) {

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = { 7, 4, 5, 6 };

        int result = solution(bridge_length, weight, truck_weights);

        System.out.println(result);

    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> passing = new LinkedList<>();

        int n = 0;

        for(int t : truck_weights){
            
            while (true) {

                if(passing.isEmpty()){
                    passing.offer(t);
                    n += t;
                    answer++;
                    break;
                } else if(passing.size() == bridge_length){
                    n -= passing.poll();
                } else {
                    if(n + t> weight){
                        passing.offer(0);
                        answer++;
                    }else{
                        passing.offer(t);
                        n += t;
                        answer++;
                        break;
                    }
                }
                
            }
                        
        }


        return answer+bridge_length;
    }
}