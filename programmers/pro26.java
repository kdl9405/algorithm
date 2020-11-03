
import java.util.Arrays;

public class pro26 {
    public static void main(String[] args) {
        
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};

        System.out.println(solution(routes));

    }
    static int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, (r1,r2) ->{
            return r1[0] - r2[0] ; 
        });

        int out = routes[0][1];

        for(int i = 1; i<routes.length; i++){
            if (routes[i][0] <= out) {
                
                out = Math.min(out,routes[i][1]);
            }else {
                out = routes[i][1];
                answer++;
            }
        }

                
        return answer;
    }

   
}
