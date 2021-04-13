package BOJ;

import java.io.*;
import java.util.*;

/*
    N과 M (12) 
    
    160ms
    
 */

public class BOJ15666 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        numbers = set.stream().mapToInt(i -> i).toArray();
        Arrays.sort(numbers);

        arr = new int[m];
        sb = new StringBuilder();

        findP(0, m);

        System.out.println(sb.toString().trim());
    }

    static int[] numbers;
    static int[] arr;
    static StringBuilder sb;

    static void findP (int depth, int r){
        if (depth == r) {
            for(int a : arr){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i<numbers.length; i++){
            if (depth>0) {
                if (arr[depth-1] > numbers[i]) {
                    continue;
                }
            }

            arr[depth] = numbers[i];
            findP(depth+1, r);
        }
    }
}
