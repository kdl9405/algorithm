package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2751 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[20000001];

        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine()) + 10000000] = true;
        }

        for(int i = 0; i < 20000001; i++){

            if(arr[i]){
                sb.append(i-10000000).append("\n");
            }
        }

        System.out.println(sb);

    }
}