package softeer.coding;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class sol2 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a,b)->{
            return b[1] - a[1];
        });

        StringBuilder sb= new StringBuilder();

        for(int[] a : arr){
            sb.append(a[0]+" ");
        }

        System.out.println(sb.toString().trim());
    }
    
}
