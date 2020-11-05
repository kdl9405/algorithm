public class test1 {
    public static void main(String[] args) {
        int n = 4;
        int[][] ladder = { { 1, 0, 1 }, { 0, 1, 0 }, { 0, 0, 1 }, { 0, 0, 0 }, { 1, 0, 0 } };

        int[] result = solution(n, ladder);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    static int[] solution(int n, int[][] ladder) {
        int[] answer = new int[n];
        for(int i = 0; i<n; i++){
            answer[i] = i;
        }
        
        for(int i = 0; i<n; i++){
            for(int[] lad : ladder){
                if (answer[i]-1>=0 && lad[answer[i]-1] == 1) {
                    answer[i]--;
                }else if (answer[i]<n-1 && lad[answer[i]] == 1) {
                    answer[i]++;
                }
            }
        }

        for(int i = 0; i<n; i++){
            answer[i]++;
        }       

        return answer;
    }
}
