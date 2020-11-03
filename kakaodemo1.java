import java.util.HashSet;

/**
 * kakaodemo1
 */
public class kakaodemo1 {

    public static void main(String[] args) {

        int[][] v = {{1, 4}, {3, 4}, {3, 10}};


        solution(v);
        // System.out.println(solution(v));
        
    }

    public static int[] solution(int[][] v) {
        int[] answer = new int[2];

        HashSet<Integer> x = new HashSet<>();
        HashSet<Integer> y = new HashSet<>();


        for(int i=0; i<3; i++){

            if(x.contains(v[i][0])){
                x.remove(v[i][0]);
            }else if(!x.contains(v[i][0])){
                x.add(v[i][0]);
            }
            
            if(y.contains(v[i][1])){
                y.remove(v[i][1]);
            }else if(!y.contains(v[i][1])){
                y.add(v[i][1]);
            }
        }

        
        answer[0] = x.hashCode();
        answer[1] = y.hashCode();

        System.out.println(answer[1]);
        

        return answer;
    }
}