package kakao;

import java.io.*;
import java.util.*;


public class pro2 {

    public static void main(String[] args) {
        
        int[][] needs = {{1, 0, 0 }, {1, 0, 0}, {1, 0, 0}, {1, 0, 1}, {1, 1, 0}, {1, 1, 1}};
        int r = 3;

        System.out.println(solution(needs, r));

    }

    static HashMap<String, Integer> goods;
    static boolean[] combination;
    static int max;
    
    public static int solution(int[][] needs, int r) {

        goods = new HashMap<>();
        StringBuilder sb;
        int n = needs[0].length;

        for(int[] need: needs){
            sb = new StringBuilder();
            for(int i = 0; i<n; i++){
                if (need[i] == 1) {
                    sb.append(i+" ");
                }
            }            
            goods.put(sb.toString(), goods.getOrDefault(sb.toString(),0) +1);
        }
        
        combination = new boolean[n];   
        max = 0;
        nCr(n, r, 0, 0);

        return max;
    }


    static void nCr(int n, int r, int depth, int x){

        if (depth == r) {
            // 개수확인
            int count = 0;
            loop:
            for(String good : goods.keySet()){
                String[] parts = good.trim().split(" ");
                for(String part : parts){
                    if (!combination[Integer.parseInt(part)]) {
                        continue loop;       
                    }
                }
                count += goods.get(good);
            }

            max = Math.max(max, count);

            return;
        }

        for(int i = x; i<n; i++){
            if (!combination[i]) {
                combination[i] = true;
                nCr(n, r, depth+1, i+1);
                combination[i] = false;
            }
        }
    }
}
