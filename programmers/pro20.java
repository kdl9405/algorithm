
//카펫
public class pro20 {
    
    public static void main(String[] args) {
        
        System.out.println(solution(10, 2));

    }


    static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;

        for(int y = 1; y< total; y++){
            
            if ((total % y) != 0) {
                continue;                
            }else{
                int x = total / y;

                if (brown == (2*(x+y-2)) && (yellow == (x-2)*(y-2))) {
                    answer[0] = y;
                    answer[1] = x;
                    return answer;
                }
            }

        }

        return answer;
    }
}

