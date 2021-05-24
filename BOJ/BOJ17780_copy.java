package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
    새로운 게임


    1. 말이 가장 아래에 있는지 체크하면서 이동..
    2. 어떻게 겹쳐진 말을 체크할건가..(맨 아래, 맨 위도 체크해야함)


*/

public class BOJ17780_copy {

    private static class Node {
		int n, d;
		Node(int n, int d) {
			this.n = n;
			this.d = d;
		}
	}
	private static int N, K, color[][], horse[][];
	private static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	private static LinkedList<Node>[][] map; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		color = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				color[i][j] = Integer.parseInt(st.nextToken());
		}
				
		horse = new int[K][2];	//말의 x위치, y위치 
		map = new LinkedList[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = new LinkedList<>();
		
		int a, b, c;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken());
			
			if (c == 1) c = 0;
			else if (c == 4) c = 1;
			
			horse[i][0] = a;
			horse[i][1] = b;
			
			map[a][b].add(new Node(i, c));
		}
		game();
	}

    static void testPrint(){
        StringBuilder sb = new StringBuilder();
        sb.append("-----------\n");
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if (map[i][j].isEmpty()) {
                    sb.append("- ");

                }else{
                    sb.append(map[i][j].getFirst().n+" ");
                }
            }sb.append("\n");
        }

        System.out.println(sb.toString());
    }

	private static void game() {

        testPrint();

		for (int t = 1; t <= 1000; t++) {

            System.out.println("!!!!  T "+t );

			for (int k = 0; k < K; k++) {
				int x = horse[k][0];
				int y = horse[k][1];
				int d = map[x][y].get(0).d;
				
				if (map[x][y].get(0).n != k)
					continue;
				
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || color[nx][ny] == 2) {
					map[x][y].get(0).d = d = (d + 2) % 4;
					nx = x + dx[d];
					ny = y + dy[d];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= N || color[nx][ny] == 2) {
						continue;
					} else {
						if (move(x, y, nx, ny, color[nx][ny])) {
							System.out.println(t);
							return;
						}
					}
					
				} else {
					if (move(x, y, nx, ny, color[nx][ny])) {
						System.out.println(t);
						return;
					}
				}
			}

            testPrint();
		}
		System.out.println("-1");
	}

	private static boolean move(int px, int py, int nx, int ny, int color) {
		if (color == 0) {	//흰색
			while (map[px][py].size() > 0) {
				Node temp = map[px][py].removeFirst();
				horse[temp.n][0] = nx;
				horse[temp.n][1] = ny;
				map[nx][ny].add(temp);
			}
		} else {		//빨간색 
			while (map[px][py].size() > 0) {
				Node temp = map[px][py].removeLast();
				horse[temp.n][0] = nx;
				horse[temp.n][1] = ny;
				map[nx][ny].add(temp);
			}
		}
		if (map[nx][ny].size() >= 4) return true;
		else return false;
 	}
}