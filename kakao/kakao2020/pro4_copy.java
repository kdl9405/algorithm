package kakao.kakao2020;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pro4_copy {

    public static void main(final String[] args) {

        int[][] key = { {1,2}, {2,1}, {3,1} };
        int[][] lock = { {1,2}};


        List<int[]> A =  Arrays.asList(key);
        
        List<int[]> B = Arrays.asList(lock);

        for(int[] val : A){
            System.out.println(val[0] +" "+ val[1]);
        }
        for(int[] val : B){
            System.out.println(val[0] +" "+ val[1]);
        }

       

        System.out.println( B.get(0));

    }  
}
