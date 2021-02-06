package programmers;

import java.util.*;

/* 
    하노이 경로

    하노이n = 2*(하노이(n-1))+1

*/
public class pro125 {
    

    public static void main(String[] args) {

        int n = 2;
        int[][] answer = solution(n);

        for(int[] a :answer){
            System.out.println(a[0]+" "+a[1]);
        }
    }

    public static int[][] solution(int n) {

        list = new ArrayList<>();

        int from = 1;
        int mid = 2;
        int to = 3;

        move(n, from, mid, to);
        int[][] answer = new int[list.size()][2];

        for(int i =0; i<answer.length; i++){
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }

        
        return answer;
    }

    static List<Integer[]> list;

    static void move(int n, int from, int mid, int to){
        if (n == 1) {
            list.add(new Integer[]{from, to});
            return;
        }

        move(n-1, from, to, mid);
        list.add(new Integer[]{from, to});
        move(n-1, mid, from, to);
    }
}
