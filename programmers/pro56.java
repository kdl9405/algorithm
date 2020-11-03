package programmers;

/**
 * 삼각 달팽이
 */
public class pro56 {

    public static void main(String[] args) {

        int[] result  = solution(5);

        for(int v : result){
            System.out.print(v+" ");
        }
        
    }

    static int[] solution(int n) {
        int[][] map = new int[n][n];
        int max = ((1+n)*n)/2;

        int[] answer = new int[max];

        int i = 0;
        int j = 0;
        int v = 1;

        map[i][j] = v;

        while (v < max) {
            while (i+1 < n && v<max && map[i+1][j] == 0 ) {
                map[++i][j] = ++v;
            }

            while (j+1<n && v<max && map[i][j+1] == 0) {
                map[i][++j] = ++v;
            }

            while (i-1>0 && j-1 > 0 && v<max && map[i-1][j-1] == 0) {
                map[--i][--j] = ++v;
            }
        }

        v = 0;

        for(i = 0; i<n; i++){
            for(j = 0; j<n; j++){
                if (map[i][j] != 0) {
                    answer[v++] = map[i][j];
                }
            }
        }        
       
        return answer;
    }

    
}