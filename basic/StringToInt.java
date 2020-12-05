package basic;

import java.util.*;

public class StringToInt {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        
        int num = stringToInt(s);

        System.out.println(num);

    }

    static int stringToInt(String s) {

        int num = 0;

        String[] str = s.split("");

        int x = 1;

        for (int i = str.length - 1; i >= 0; i--) {
            num += (Integer.parseInt(str[i]) * x);
            x *= 10;
        }

        return num;

    }
}
