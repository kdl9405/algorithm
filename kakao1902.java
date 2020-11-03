import java.util.*;

/**
 * kakao1902
 */
public class kakao1902 {

    public static void main(String[] args) {
        

        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

        
        for (int i = 0; i < solution(s).length; i++){
            System.out.println(solution(s)[i]);
        
        }
       

    }

    public static int[] solution(String s) {

        s = s.replace("{{", "");
        s = s.replace("}}", "");
        s = s.replace("},{", " ");

        String[] strArr = s.split(" ");       

        List<Integer> result = new ArrayList<>();
         Arrays.sort(strArr, Comparator.comparingInt(String::length));

        String str = String.join(",", strArr);


        String[] numbers = str.split(",");

        for(int i = 0; i<numbers.length;i++){
            if(!result.contains(Integer.parseInt(numbers[i]))){
                result.add(Integer.parseInt(numbers[i]));
            }
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        
        }
        return answer;
      
    }

}