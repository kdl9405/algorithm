package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11054 {

    static int n;
    static int[] up;
    static int[] down;
    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        up = new int[n];
        down = new int[n];
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS();
        LDS();

        int max = 0;
        for(int i = 0; i<n; i++){
            if (max < up[i] + down[i]) {
                max = up[i] + down[i];
            }
        }

        System.out.println(max-1);

    }

    static void LIS() {
        for(int i = 0; i<n; i++){
            up[i] = 1;

            for(int j = 0; j<i; j++){
                if (arr[i] > arr[j] && up[i] < up[j]+1) {
                    up[i] = up[j]+1;
                }
            }
        }
    }

    static void LDS(){
        for(int i = n-1; i>=0; i--){
            down[i] = 1;

            for(int j = n-1;j > i; j--){
                if (arr[i] > arr[j] && down[i] < down[j]+1 ) {
                    down[i] = down[j]+1;
                }
            }
        }
    }
}
