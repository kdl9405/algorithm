package programmers;

import java.util.*;

/**
 * 외벽 점검
 */
public class pro89 {

    public static void main(String[] args) {

        int[] weak = { 1, 5,6,10 };
        int[] dist = { 1,2,3,4};
        int n = 12;

        System.out.println(solution(n, weak, dist));

    }

    static int solution(int n, int[] weak, int[] dist) {
        int answer = -1;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i<weak.length; i++){
            queue.offer(weak[i]);
        }
        
        weakLine = new int[weak.length][weak.length];
        
        for(int x = 0; x< weakLine.length; x++){
            int[] line = queue.stream().mapToInt(i->i).toArray();
            for(int j = 0; j<weakLine.length; j++){
                weakLine[x][j] = line[j];
            }
            queue.offer(queue.poll()+n);
        }
        
        int count = 1;
        while(count <= dist.length){
            friends = new boolean[dist.length];
            arr = new int[count];
            distCheck(0,0,count, dist);
            if(result){
                answer = count;
                break;
            }
            count++;
        }
        
        return answer;
    }
    
    static boolean[] friends;
    static int[] arr;
    static int[][] weakLine;
    static boolean result = false;
    
    static void distCheck(int x, int depth, int count, int[] dist){
        if(depth == count){

            if(possible()){
                result = true;
            }
            return;
        }
        for(int i = 0; i< dist.length; i++){
            if(!friends[i]){
                friends[i] = true;
                arr[depth] = dist[i];
                distCheck(i+1, depth +1, count, dist);
                friends[i] = false;                
            }
        }
        return;
    }
    
    static boolean possible(){
        boolean check = false;
       
        for(int[] w : weakLine){
            int[] temp = arr.clone();
            
            check = true;
            int x = 0;
            int now = w[0] + temp[0];
            for(int i = 0; i<w.length; i++){

                System.out.print("now  = " + now +"   w[i] = " + w[i] +"\n");


                if(now >= w[i]){
                    continue;
                }else{
                    x++;
                    if(x<temp.length){
                        now = w[i] + temp[x];
                    }else{
                        check = false;
                        break;
                    }
                }
            }
            if(check){
                return true;
            }
        }
        return check;
    }
}