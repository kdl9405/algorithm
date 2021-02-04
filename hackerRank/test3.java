package hackerRank;

import java.util.*;

public class test3 {
    public static void main(String[] args) {
        
    }

    public static List<Integer> order(int cityNodes, List<Integer> cityFrom, List<Integer> cityTo, int company) {
        
        List<Integer> answer = new ArrayList<>();
        
        HashMap<Integer, HashSet<Integer>> road = new HashMap<>();
        
              
        
        boolean[][] arr = new boolean[cityNodes+1][cityNodes+1];  
        for(int i = 0; i<cityFrom.size(); i++){
            int from = cityFrom.get(i);
            int to = cityTo.get(i); 
        
            arr[from][to] = true;
            arr[to][from] = true;            
        } 
        
        for(int i = 1; i<=cityNodes; i++){
            HashSet<Integer> dest = new HashSet<>();
            for(int j = 1; j<=cityNodes; j++){
                
                if (j != company && arr[i][j]) {
                    dest.add(j);
                }
            }
            road.put(i, dest);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(company);
        
        boolean[] visit = new boolean[cityNodes+1];
                
        while (true) {            
            
            HashSet<Integer> temp = new HashSet<>();

            while (!pq.isEmpty()) {                
                int node = pq.poll();
                
                if (!visit[node]) {
                   if(road.containsKey(node)){    
                    
                     for(Integer c : road.get(node)){
                        if (!visit[c] && !answer.contains(c)) {
                            temp.add(c);   
                            }
                        } 
                    road.remove(node);             
                    } 
                }
                visit[node] = true;  
            }            
                    
            if (temp.isEmpty()) {
                break;
            }else{
                List<Integer> list = new ArrayList<>();
                list.addAll(temp);
                
                Collections.sort(list);
                
                pq.addAll(list);
                answer.addAll(list);                
            }                      
            
        }        
        
        return answer;
    }

}
}
