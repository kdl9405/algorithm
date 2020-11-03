
import java.util.*;

public class pro2 {

	public static void main(String[] args) {

		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		System.out.print(solution(array, commands));

	}

	public static int[] solution(int[] array, int[][] commands) {

		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {

			int[] temp = new int[commands[i][1]-commands[i][0]+1];

			for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {

				int x = j + 1 - commands[i][0];

				temp[x] = array[j];

			}
			Arrays.sort(temp);

			answer[i] = temp[commands[i][2] - 1];

		}

		for(int i=0; i<answer.length;i++){
			System.out.println(answer[i]);
		}

		return answer;
	}
}