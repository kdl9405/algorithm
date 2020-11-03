package programmers;

import java.util.Arrays;
import java.util.HashSet;

public class winter1 {

    public static void main(String[] args) {

        int[][] delivery = { { 5, 6, 0 }, { 1, 3, 1 }, { 1, 5, 0 }, { 7, 6, 0 }, { 3, 7, 1 }, { 2, 5, 0 } };
        int n = 7;

        System.out.println(solution(n, delivery));

    }

    static String solution(int n, int[][] delivery) {

        String answer = "";

        StringBuilder sb = new StringBuilder();
        
        HashSet<Integer> set = new HashSet<>();
        boolean[] noCheck = new boolean[n+1];
        
        Arrays.sort(delivery, (d1,d2) ->{
            return d2[2] - d1[2];
        });
        
        for(int[] d : delivery){
            switch(d[2]){
                case 1 :
                    set.add(d[0]);
                    set.add(d[1]);
                    break;
                case 0:
                    if(set.contains(d[0])){
                        noCheck[d[1]] = true;
                    }else if(set.contains(d[1])){
                        noCheck[d[0]] = true;
                    }
                    break;
            }
        }
        
        for(int i = 1; i<=n; i++){
            if(set.contains(i)){
                sb.append("O");
            }else if(noCheck[i]){
                sb.append("X");
            }else {
                sb.append("?");
            }
        }
        
        answer = sb.toString();
        
        return answer;
    }
}