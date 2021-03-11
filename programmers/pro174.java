package programmers;

import java.util.*;


/* 
    여행경로
*/

public class pro174 {
    
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        String[] answer = solution(tickets);
        for(String a : answer){
            System.out.print(a+" ");
        }
    }
    static String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        
        Arrays.sort(tickets, (t1,t2)->{
            if(t1[0].compareTo(t2[0]) == 0){
                return t1[1].compareTo(t2[1]);
            }
            return t1[0].compareTo(t2[0]);
        });
            
        visit = new boolean[tickets.length];
        route = new String[tickets.length+1];
        find = false;

        route[0] = "ICN";
        dfs(1, tickets);
   
        return answer;
    }
    
   
    static boolean[] visit;
    static String[] route;
    static String[] answer;
    static boolean find;
    
    static void dfs(int depth, String[][] tickets){ // 티켓으로 dfs

        if(depth == route.length){
            
            find = true;

            for(int i = 0; i<depth; i++){
                answer[i] = route[i];
            }
            
            return;
        }
        
        for(int i = 0; i<tickets.length; i++){            
            if(!visit[i] && route[depth-1].equals(tickets[i][0])){                
                visit[i] = true;
                route[depth] = tickets[i][1];
                dfs(depth+1, tickets);                
                visit[i] = false;
                if(find){
                    break;
                }
            }
        }
    }

}