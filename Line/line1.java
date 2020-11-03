import java.util.*;

public class line1 {

    public static void main(String[] args) {

        int[][] boxes = {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};

        System.out.println(solution(boxes));
    }

    static int solution(int[][] boxes) {
        int answer = -1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int[] box : boxes){
            map.put(box[0], map.getOrDefault(box[0], 0)+1);
            map.put(box[1], map.getOrDefault(box[1], 0)+1);
        }

        List<Integer> list = new ArrayList<>();

        for(Integer i : map.keySet()){
            if (map.get(i)%2 ==1) {
                list.add(i);
            }
        }
        
        
        answer = list.size()/2;
        

        return answer;
    }
}
