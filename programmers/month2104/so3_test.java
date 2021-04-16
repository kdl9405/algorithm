package programmers.month2104;

import java.util.*;

//  런타임 에러 3개

public class so3_test {

    public static void main(String[] args) {

        Integer a = 500000;
        Integer b = 500000;
        System.out.println(a == b);

        Integer x = 2000;
        Integer y = 2000;
        System.out.println(x == y);


        List<Integer> list = new ArrayList<>();
        for(int i = 1000; i<=10000; i+=1000){
            list.add(i);
        } 

        for(Integer l : list){
            System.out.print(l +"  ");
            System.out.println(l == x);
        }

    }

}