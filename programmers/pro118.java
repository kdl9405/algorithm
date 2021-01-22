package programmers;

//리틀 프렌즈 사천성

public class pro118 {

    public static void main(String[] args) {

        int m = 3;
        int n = 3;
        String[] board = {"DBA", "C*A", "CDB"};

        System.out.println(solution(m, n, board));

    }

    static String solution(int m, int n, String[] board) {
        String answer = "";

        map = board.clone();



        return answer;
    }

    static String[] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static void delete(int x, int y){

        char target = map[x].charAt(y);

        loop:
        for(int i = 0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            while (true) {
                if (nx<0 || nx>=map.length || ny < 0 || ny>=map[0].length()) {
                    break;
                }

                if (map[nx].charAt(ny) != target && map[nx].charAt(ny) != '.') {
                    break;
                }
                
                if (dx[i] == 0) {
                    for(int j = -1; nx>=0; j--){
                        if (map[nx+j].charAt(ny) == target) {
                            break loop;
                        }else if(map[nx+j].charAt(ny) == '.'){
                            continue;
                        }else{
                            break;
                        }
                    }
                    for(int j = 1; nx<map.length; j++){
                        if (map[nx+j].charAt(ny) == target) {
                            break loop;
                        }else if(map[nx+j].charAt(ny) == '.'){
                            continue;
                        }else{
                            break;
                        }
                    }
                }


                nx+= dx[i];
                ny+= dy[i];
            }

            
            
        }
    }
}
