
//정수 삼각형
//시간초과

public class pro28copy {

    public static void main(final String[] args) {

        final int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };

        System.out.println(solution(triangle));

    }

    static int max = Integer.MIN_VALUE;

    static int solution(final int[][] triangle) {
        int answer = 0;

        dfs(0, 0, 0, triangle);

        answer = max;

        return answer;
    }

    static void dfs(final int x, final int y, int sum, final int[][] triangle){

        if (x == triangle.length) {
            
            max = Math.max(max, sum);
            sum = 0;
            return;
        }else{

            sum += triangle[x][y];

            dfs(x+1, y, sum, triangle);
            dfs(x+1, y+1,sum, triangle);

        }

        
    }
}
