package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2876 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];

        int count = 0;
        int grade = 0;

        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int j = 1; j<=5; j++){
                if (a == j || b == j) {
                    arr[j]++;

                    if (arr[j] > count || (arr[j] == count && grade > j)) {
                        count = arr[j];
                        grade = j;
                    }
                }else{
                    arr[j] = 0;
                }
            }
        }

        System.out.println(count + " " + grade);
    }
}
