package programmers.month2110;

/* 
    역시나 시간초과.
*/

public class sol3_copy {

    public long solution(int n, int m, int x, int y, int[][] queries) {

        long answer = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                int nx = i;
                int ny = j;

                for (int[] query : queries) {
                    switch (query[0]) {
                        case 0:

                            nx -= query[1];

                            break;

                        case 1:

                            nx += query[1];

                            break;
                        case 2:
                            ny -= query[1];

                            break;
                        case 3:
                            ny += query[1];

                            break;
                    }

                    if (nx < 0) {
                        nx = 0;
                    }else if(nx >=n){
                        nx = n-1;
                    }

                    if (ny < 0) {
                        ny = 0;
                    }else if(ny >= m){
                        ny = m-1;
                    }

                    if (nx == x && ny == y) {
                        answer++;
                        break;
                    }

                }

            }
        }

        return answer;
    }

}
