package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/* 
    좌표 압축
*/
public class BOJ18870 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] numbers = input.clone();

        Arrays.sort(numbers);

        HashMap<Integer, Integer> sequence = new HashMap<>();

        int index = 0;
        for (int number : numbers) {
            if (!sequence.containsKey(number)) {
                sequence.put(number, index);
                index++;
            }   
        }

        StringBuilder sb = new StringBuilder();
        for (int i : input) {
            sb.append(sequence.get(i)).append(" ");
        }

        System.out.println(sb.toString().trim());

    }

}
