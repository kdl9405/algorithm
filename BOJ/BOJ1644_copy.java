package BJ;

import java.io.*;
import java.util.*;

/* 
    소수의 연속합
    300ms
*/
public class BJ1644_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        prime = new ArrayList<>();
        makePrimArr(n);

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
     
        while (true){
            if (sum >= n) {
                if (sum == n) {
                    count++;
                }
                sum -= prime.get(left);
                left++;
            }else if (right == prime.size())  {
                break;
            }else{
                sum += prime.get(right);
                right++;
            }
        }

        System.out.println(count);


    }

    static List<Integer> prime;

    static void makePrimArr (int n){

        boolean[] nCheck = new boolean[n+1];
        
        for(int i = 2; i<=n; i++){
            if (!nCheck[i]) {
                prime.add(i);
            }
            for(int j = 2; i*j<=n; j++){
                nCheck[i*j] = true;
            }
        }

    }
}
