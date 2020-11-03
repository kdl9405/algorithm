import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14889 {

    static int n;
    static int[][] map;
    static boolean[] team_check;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        team_check = new boolean[n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        team(0,0);

        System.out.println(min); 
        
                
    }

    static void team(int x, int count){

        if(count == n/2){
            
            score();

            return;
        }

        for(int i = x; i< n; i++){
            
            if(!team_check[i]){
                team_check[i] = true;
                team(i+1, count+1);
                team_check[i] = false;
            }
        }
    }

    static void score() {
        int start_score = 0;
        int link_score = 0;

        for(int i = 0; i<n-1; i++){
            for(int j = i+1 ; j<n; j++){

                if(team_check[i] == true && team_check[j] == true){
                    start_score = start_score + map[i][j] + map[j][i];
                }

                if(team_check[i] == false && team_check[j] == false){
                    link_score = link_score + map[i][j] + map[j][i];
                }
            }
        }

        int diff = Math.abs(start_score - link_score);

        if(diff == 0){
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(diff, min);


    }
}