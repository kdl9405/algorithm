package programmers;

import java.util.*;

/* 
    베스트 앨범
*/
public class pro169 {
    public static void main(String[] args) {

        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };

        solution(genres, plays);
    }

    static int[] solution(String[] genres, int[] plays) {
 
        List<Integer> resultList = new ArrayList<>();
        HashMap<String, Integer> genreCount = new HashMap<>();
        HashMap<String, List<Integer>> genreIndex = new HashMap<>();
        
        for(int i = 0; i<plays.length; i++){
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i],0)+plays[i]);
            if(!genreIndex.containsKey(genres[i])){
                genreIndex.put(genres[i], new ArrayList<>());                
            }
            genreIndex.get(genres[i]).add(i);
        }
        
        Object[] arr =  genreCount.keySet().toArray();
        
        Arrays.sort(arr, (a1,a2)->{
            return genreCount.get(a2) - genreCount.get(a1);
        });
            
        for(Object g : arr){
            String genre = g.toString();
            List<Integer> list = genreIndex.get(genre);
            
            if(list.size()> 1){   
                Collections.sort(list, (l1,l2)->{
                    if(plays[l1] == plays[l2]){
                        return l1-l2;
                    }
                 return plays[l2] - plays[l1];
                });
            }
            
            for(int i = 0; i<2 && i<list.size(); i++){
                resultList.add(list.get(i));
            }
        }
               
        
        int[] answer = resultList.stream().mapToInt(i->i).toArray();
        return answer;
    }
}