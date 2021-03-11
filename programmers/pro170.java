package programmers;

import java.util.*;
/* 
    디스크 컨트롤러

*/
public class pro170 {
    public static void main(String[] args) {
        int[][] jobs = {{0,9},{0,4},{0,5},{0,7},{0,3}};
        System.out.println(solution(jobs));
    }
    
    static int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (j1,j2)->{
            
            if(j1[0] == j2[0]){
                return j1[1] - j2[1];
            }
            
            return j1[0] - j2[0];
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->{            
            if(p1[1] == p2[1]){
                return p1[0] - p2[0];
            }            
            return p1[1] - p2[1];
        });
        
        pq.offer(jobs[0]);
        int time = jobs[0][0];
        int i = 1;
        int count = jobs.length;
        
        while(count-- > 0){
            int[] job = pq.poll();
            if(time < job[0]){
                time = job[0];
            }
            time += job[1];            
            answer += (time-job[0]);
            
            while(i < jobs.length){
                 if(jobs[i][0] > time){
                    if(pq.isEmpty()){
                        pq.offer(jobs[i]);
                        i++;
                    }
                    break;
                }else {
                    pq.offer(jobs[i]);
                    i++;
                }
            }
           
        }
        return answer / jobs.length;
    }
}