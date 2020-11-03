package BJ;

import java.util.Scanner;

public class BJ2292 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sc.close();

        int x = 0;
        int i = 0;
        while (true) {

            if (N==1) {
                System.out.println(1);
                break;
            }else if(6*x+1>N-1){
                System.out.println(i+1);
                break;
            }else{

                i +=1;                

                x = x+i;
            }
            
        }
    }
}