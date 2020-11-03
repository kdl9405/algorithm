package programmers;

import java.util.*;
/**
 * 야근 지수
 */
public class pro97 {

    public static void main(String[] args) {
        int[] works = {1,1};
        int n = 3;

        System.out.println(solution(n, works));
    }

    static long solution(int n, int[] works) {
        long answer = 0;

        HashMap<Integer, Integer> hash = new HashMap<>();

        int max = 0;
        for(int i = 0; i<works.length; i++){
            hash.put(works[i], hash.getOrDefault(works[i], 0)+1);
            max = Math.max(max, works[i]);
        }

        while (true) {

            if (n>= (hash.get(max))) {
                n-= hash.get(max);
                hash.put(max-1, hash.getOrDefault(max-1, 0)+hash.get(max));
                hash.remove(max);
                max--;
            }else{
                hash.put(max, hash.getOrDefault(max, 0)-n);
                hash.put(max-1, hash.getOrDefault(max-1, 0)+n);
                n=0;
            }             
            
            if (n == 0) {
                break;
            }
        }

        for(Integer i : hash.keySet()){
            if (i>0) {
                answer+= ((long)i*(long)i*(long)hash.get(i));
            }
        }

        return answer;
    }
}