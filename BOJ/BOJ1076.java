package BOJ;

/* 
    저항
*/

import java.util.Scanner;

public class BOJ1076 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long num = change(sc.next())*10;
        num += change(sc.next());

        num*=(long)Math.pow(10, change(sc.next()));

        System.out.println(num);
        

    }

    static int change(String s) {

        int num = 0;

        switch (s) {
            case "black":
                num = 0;
                break;

            case "brown":
                num = 1;
                break;
            case "red":
                num = 2;
                break;
            case "orange":
                num = 3;
                break;
            case "yellow":
                num = 4;
                break;
            case "green":
                num = 5;
                break;
            case "blue":
                num = 6;
                break;
            case "violet":
                num = 7;
                break;
            case "grey":
                num = 8;
                break;
            case "white":
                num = 9;
                break;
        }

        return num;
    }
}
