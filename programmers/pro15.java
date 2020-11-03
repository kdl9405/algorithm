
import java.util.Arrays;

//k번째 수
public class pro15 {
    
    public static void main(String[] args) {

        int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		System.out.print(solution(array, commands));
        
    }
    static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int i = 0;
        while (i < answer.length) {
            
            int[] arr = new int[commands[i][1] - commands[i][0] +1];

            for(int j = 0; j<arr.length; j++){
                
                arr[j] = array[commands[i][0] -1 + j];

            }

            Arrays.sort(arr);

            answer[i] = arr[commands[i][2]-1];

            i++;
            
        }

        return answer;
    }
}
