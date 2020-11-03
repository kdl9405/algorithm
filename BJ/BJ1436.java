package BJ;


import java.util.Scanner;

public class BJ1436 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.close();

        int num = 666;
        int count = 1;

        while (count != n) {
            num++;
            if (String.valueOf(num).contains("666")) {
                count++;
            }
        }

        System.out.println(num);               

    }
}