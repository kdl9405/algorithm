package BOJ;

import java.io.*;
import java.util.*;

/* 
    N과 M (11)

    408ms
*/
public class BOJ15665 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<Integer> num = new HashSet<>();

        arr = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num.add(Integer.parseInt(st.nextToken()));
        }

        numbers = num.stream().mapToInt(i -> i).toArray();
        Arrays.sort(numbers);

        result = new StringBuilder();
        
        findP(0, m);

        System.out.println(result);

    }

    static int[] numbers;
    static int[] arr;
    static StringBuilder result;

    static void findP (int depth, int r){
        if (depth == r) {
            for(int a : arr){
                result.append(a).append(" ");
            }
            result.append("\n");

            return;
        }

        for(int i = 0; i<numbers.length; i++){
            arr[depth] = numbers[i];
            findP(depth+1, r); 
        }
    }
}
