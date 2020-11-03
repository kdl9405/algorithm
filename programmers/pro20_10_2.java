/**
 * pro20_10_2
 */
public class pro20_10_2 {

    public static void main(String[] args) {

        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};

        int[] result = solution(arr);

        System.out.println(result[0] +" "+ result[1]);
        
    }

    static int[] solution(int[][] arr) {
        int[] answer = new int[2];

        onecount = 0;
        zerocount = 0;
        map = arr.clone();

        devide(0, 0, arr.length);

        answer[0] = zerocount;
        answer[1] = onecount;

        return answer;
    }

    static int[][] map;
    static int onecount;
    static int zerocount;

    static boolean checkSame(int x1, int y1, int x2, int y2){

        int p = map[x1][y1]; 

        for(int i = x1; i<x2; i++){
            for(int j = y1; j<y2; j++){
                if(p != map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    static void devide(int x1, int y1, int len){
        if (len == 1) {
            if (map[x1][y1] == 1) {
                onecount++;
            }else{
                zerocount++;
            }
            return;
        }

        if (checkSame(x1, y1, x1+len, y1+len)) {
            if (map[x1][y1] == 1) {
                onecount++;
            }else{
                zerocount++;
            }
            return;
        }else{            
            len = len/2;
            devide(x1, y1, len);
            devide(x1, y1+len, len);
            devide(x1+len, y1, len);
            devide(x1+len, y1+len, len);
        }
    }
}