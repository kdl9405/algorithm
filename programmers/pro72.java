import java.util.*;
/**
 * [1차] 캐시
 */
public class pro72 {

    public static void main(String[] args) {
        
    }


    static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        Queue<String> queue = new LinkedList<>();
        
        for(String city : cities){
            city = city.toLowerCase();
            if(queue.contains(city)){
                queue.remove(city);
                queue.offer(city);
                answer++;
            }else{
                if(queue.size()<cacheSize){
                    queue.offer(city);
                }else{
                    queue.poll();
                    queue.offer(city);
                }
                answer+=5;
            }
        }
        
        return answer;
    }
}