package BJ;

import java.util.Scanner;

public class BJ1978 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);

        int n = Integer.parseInt(sc.nextLine());
        
        int count = 0;

        int[] num = new int[n];

        for(int i = 0; i<n; i++){
            num[i] = sc.nextInt();

            int check = 0;
            
            for(int j=1; j<num[i]; j++){
                if(num[i]%j == 0){
                    check++;

                    if (check == 2) {
                        break;
                    }
                }
            }

            if(check == 1){
                count++;
            }
            
        }

        sc.close();

        System.out.println(count);
    }
}