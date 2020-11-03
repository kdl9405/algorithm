
import java.util.*;
import java.util.Map.Entry;

public class pro7 {
    public static void main(String[] args) {
        
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        solution(genres, plays);


    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = new int[51];

        HashMap<String,Integer> genre_map = new HashMap<>();
        HashMap<String,String> play_map = new HashMap<>();

        for(int i = 0; i<genres.length; i++){

            genre_map.put(genres[i], genre_map.getOrDefault(genres[i], 0)+plays[i]);
            play_map.put(genres[i], play_map.getOrDefault(genres[i], "")+i+" ");
        }

        List<Entry<String,Integer>> genre_list = new ArrayList<Entry<String,Integer>>(genre_map.entrySet());



        for(int i=0; i<genre_list.size();i++){

            String[] temp = play_map.get(genre_list.get(i).getKey()).split(" ");
            

            int[][] temp2 = new int[temp.length][2];

            for(int j = 0; j<temp.length; j++){
                temp2[j][0] = Integer.parseInt(temp[j].replaceAll(" ", ""));
                temp2[j][1] = plays[temp2[j][1]];

            }

           
            
            for(int j = 0; j<temp2.length; j++){
                System.out.println(temp2[j][0]);
                System.out.println(temp2[j][1]);

            }
            
        }


        for(int i = 0; i<4; i++){
            System.out.println(answer[i]);
        }
        
        
        return answer;
    }
}
