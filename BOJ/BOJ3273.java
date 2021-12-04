package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
    두 수의 합
*/
public class BOJ3273 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] num = new int[n];
        StringTokenizer st=  new StringTokenizer(br.readLine());

        for(int i = 0; i<n ;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int x = Integer.parseInt(br.readLine());

        int left = 0;
        int right = n-1;

        int count = 0;

        while (left<right) {

            int sum = num[left]+num[right];
            
            if (sum == x) {
                count++;
                left++;
                right--;
            }else if (sum < x) {
                left++;
            }else{
                right--;
            }
        }

        System.out.println(count);

    }
}
