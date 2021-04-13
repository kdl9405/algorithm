package BOJ;

import java.util.Scanner;

public class BOJ2231 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String numSt = sc.nextLine();

        sc.close();

        int numLength = numSt.length();
        int n = Integer.parseInt(numSt);
        
        int result = 0;
        for(int i = n-(numLength*9); i<n; i++){

            int num = i;
            int sum=0;

            while (num != 0) {
                
                sum += num % 10;

                num = num/10;
            }

            if(sum+i == n){
                
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}