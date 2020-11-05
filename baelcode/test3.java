import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;

public class test3 {
    public static void main(String[] args) {

        int n = 10;
        int[] colors = {1,1,2,2,2,3,3,3,2,2};
        System.out.println(solution(n, colors));
        
    }
    static int solution(int n, int[] colors) {
        answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        queue = new LinkedList<>();
       
        int i = 0;
        int c = colors[0];
        int count = 0;

        for(int r : colors){
            if (r == c) {
                count ++;
            }else{
                queue.offer(new Integer[]{c,count});
                c = r;
                count = 1;
            }
            map.put(r, map.getOrDefault(r, 0)+1);
        }

        arr = new int[map.size()][2];
        i = 0;
        for(int r : map.keySet()){
            arr[i][0] = r;
            arr[i][1] = map.get(r);
            i++;
        }

        Arrays.sort(arr, (a1,a2)->{
            return a1[1] - a2[1];
        });

        
        queue.offer(new Integer[]{0,0});
        i = 0;
        while (true) {
           merge();
           delete(i);
           if (arr[i][1] == 0 ) {
               i++;
           }

           if (i>= arr.length ) {
                break;
           }
        }
        
        return answer;
    }

    static Queue<Integer[]> queue;
    static int[][] arr;
    static int answer;

    static void merge (){
        
        while (true) {
            Integer[] temp = queue.poll();
            if (temp[0] == 0) {
                queue.offer(temp);
                break;
            }

            if (temp[0] == queue.peek()[0]) {
                while (queue.peek()[0] == temp[0]) {
                    temp[1] += queue.poll()[1];
                }
            }
            queue.offer(temp);
        }
        return;
    }

    static void delete(int i){

        if (i == arr.length-1) {
            answer += (arr[i][1] * arr[i][1]);
            arr[i][1] = 0;
            return;
        }

        while (true) {
            Integer[] temp = queue.poll();
            if (temp[0] == 0) {
                queue.offer(temp);
                break;
            }

            if (temp[0] == arr[i][0]) {
                answer+= (temp[1]*temp[1]);
                arr[i][1] -= temp[1];
            }else{
                queue.offer(temp);
            }
        }
        return;
    }
}
