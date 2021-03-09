import java.io.*;
import java.util.*;


public class BJ10817 {
    
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);

        int[] num = new int[3];

        num[0] = sc.nextInt();
        num[1] = sc.nextInt();
        num[2] = sc.nextInt();

        sc.close();

        Arrays.sort(num);

        System.out.println(num[1]);
        

    }
}