package programmers;

import java.util.*;
/*
    최적의 행렬 곱셈

    ==> 실패
*/

public class pro181_copy {

    public static void main(String[] args) {
        
        int[][] matrix_sizes = {{1,2},{2,3},{3,4},{4,5},{5,6}};

        System.out.println(solution(matrix_sizes));
    }
 
    
    static public int solution(int[][] matrix_sizes) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        LinkedList<int[]> list = new LinkedList<>();
        
        int size = matrix_sizes.length;
        for(int i = 0; i<size-1; i++){
            pq.add(matrix_sizes[i][1]);
            list.add(matrix_sizes[i]);
        }
        list.add(matrix_sizes[size-1]);
        
        while(!pq.isEmpty()){
            int x = pq.poll();
            
            for(int i = 0; i<list.size()-1; i++){
                if(list.get(i)[1] == x){
                    int[] target = list.get(i);
                    answer += (target[0] * target[1] * list.get(i+1)[1]);
                    list.get(i+1)[0] = target[0];
                    list.remove(i);
                    break;
                }
            }

            System.out.println(answer);

            for(int[] a : list){
                System.out.print(a[0]+" "+a[1] +" , ");
            }System.out.println();
        }
        
        return answer;
    }

}
