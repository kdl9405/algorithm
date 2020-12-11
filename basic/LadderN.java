package basic;

import java.util.Scanner;

public class LadderN {

    public static void main(String[] args) {
        int count = 0;

        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();

        arr = new int[h+1][h+1];

        int one = h % 2;
        int two = h / 2;

        while (one <= h) {
            count += nCr(one + two, two);
            one += 2;
            two --;
        }

        System.out.println(count);
    }

    static int[][] arr;

    static int nCr(int n, int r){

        if (r == 0 || n == r) {
            return 1;
        }

        if(arr[n][r] != 0){
            return arr[n][r];
        }

        arr[n][r] = nCr(n-1, r-1) + nCr(n-1, r);

        return arr[n][r];
    }
}
