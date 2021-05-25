package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
    N과 M (8) 
*/
public class BOJ15657 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(num);

        arr = new int[m];
        result = new StringBuilder();

        findNum(0, 0);

        System.out.println(result.toString());

    }

    static int n, m;
    static int[] num, arr;
    static StringBuilder result;

    static void findNum(int index, int depth) {

        if (depth == m) {
            for (int a : arr) {
                result.append(a + " ");
            }

            result.append("\n");

            return;
        }

        for (int i = index; i < n; i++) {
            arr[depth] = num[i];
            findNum(i, depth + 1);
        }

        return;

    }
}
