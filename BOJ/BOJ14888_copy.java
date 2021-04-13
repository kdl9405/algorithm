import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888_copy {

    static int n;
    static int[] number;
    static int[] operator = new int[4];
    static int[] de_operator = new int[4];
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        number = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        de_operator = operator;

        result = number[0];

        // calulator(0, 1);

        dfs(number[0], 1);

        System.out.println(max+" "+min);

    }

    static void calulator(int x, int depth) {

        if (depth == n) {

            sb.append("\n");

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {

                operator[i]--;

                switch (i) {
                    case 0:

                        sb.append("+");
                        calulator(0, depth + 1);
                        break;

                    case 1:
                        sb.append("-");
                        calulator(0, depth + 1);
                        break;
                    case 2:
                        sb.append("*");
                        calulator(0, depth + 1);
                        break;

                    case 3:
                        sb.append("/");
                        calulator(0, depth + 1);
                        break;
                }

                operator[i]++;
            }
        }

    }

    public static void dfs(int num, int idx) {
		if (idx == n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
 
		for (int i = 0; i < 4; i++) {
			// 연산자 개수가 1개 이상인 경우
			if (operator[i] > 0) {
 
				// 해당 연산자를 1 감소시킨다.
				operator[i]--;
 
				switch (i) {
 
				case 0:	dfs(num + number[idx], idx + 1);	break;
				case 1:	dfs(num - number[idx], idx + 1);	break;
				case 2:	dfs(num * number[idx], idx + 1);	break;
				case 3:	dfs(num / number[idx], idx + 1);	break;
 
				}
				// 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
				operator[i]++;
			}
		}
	}
}