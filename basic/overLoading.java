package basic;

import java.util.*;

public class overLoading {
    
    public static void main(String[] args) {
        
    }
}

class addTest {

    Integer add(ArrayList<Integer> list){
        Integer answer = 0;
        for(Integer a : list){
            answer += a;
        }

        return answer;
    }

    String add(ArrayList<String> list){
        String answer = "";
        return answer;
    }
}
