package programmers;

/* 
    쿼드압축 후 개수 세기
*/

public class pro204 {
    
    public static void main(String[] args) {
        
    }

    public int[] solution(int[][] arr) {
        answer = new int[2];

        map = arr.clone();

        divide(0, 0, arr.length);

        System.out.println(answer[0] + " "+ answer[1]);

        
        return answer;
    }

    static int[][] map;
    static int[] answer;


    static void divide(int x, int y, int size){

        if (check(x, y, size)) {
            answer[map[x][y]]++;
        }else{
            size/=2;
            divide(x, y, size);
            divide(x, y+size, size);
            divide(x+size, y, size);
            divide(x+size, y+size, size);
        }

    }

    static boolean check (int x, int y, int size){

        int unit = map[x][y];

        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                if (unit != map[x+i][y+j]) {
                    return false;
                }
            }
        }

        return true;
    }
    

}
