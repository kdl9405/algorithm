import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14888 {

    static int n;
    static int[] number;
    static int[] operator = new int[4];
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int result;

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

        result = number[0];
        calulator(number[0],0);

        System.out.println(max);
        System.out.println(min);

    }

    static void calulator(int result, int depth) {

        if (depth == n - 1) {

            max = Math.max(max, result);
            min = Math.min(min, result);

            
            return;
        }

        for (int i = 0; i < 4; i++) {

            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        calulator(result + number[depth + 1], depth + 1);
                        break;

                    case 1:
                        calulator(result - number[depth + 1], depth + 1);
                        break;
                    case 2:
                        calulator(result * number[depth + 1], depth + 1);
                        break;

                    case 3:
                        calulator(result / number[depth + 1], depth + 1);
                        break;
                }

                operator[i]++;

            }

        }

    }
}