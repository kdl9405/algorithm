package BJ;

import java.io.*;

//신나는 함수 실행  
// 최적화 필요 => arr range 101 => 21변경 필요!!!
public class BJ9184 {

    static int[][][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        arr = new int[101][101][101];

        int a = 0;
        int b = 0;
        int c = 0;
        int answer = 0;

        String[] str;

        while (true) {

            str = br.readLine().split(" ");
            a = Integer.parseInt(str[0]);
            b = Integer.parseInt(str[1]);
            c = Integer.parseInt(str[2]);

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            answer = calW(a+50, b+50, c+50);


            sb.append("w("+a+", " +b+", "+c+") = "+answer+"\n");
            
        }

        System.out.println(sb);
    }

    static int calW(int a, int b, int c) {

        if (arr[a][b][c] != 0) {
            return arr[a][b][c];
        }

        if (a <= 50 || b <= 50 || c <= 50) {
            arr[a][b][c] = 1;
            return arr[a][b][c];
        }

        if (a > 70 || b > 70 || c > 70) {
            arr[70][70][70] = calW(70, 70, 70);
            return calW(70, 70, 70);
        }

        if (a < b && b < c) {
            arr[a][b][c] = calW(a, b, c - 1) + calW(a, b - 1, c - 1) - calW(a, b - 1, c);
            return arr[a][b][c];
        }

        arr[a][b][c] = calW(a - 1, b, c) + calW(a - 1, b - 1, c) + calW(a - 1, b, c - 1) - calW(a - 1, b - 1, c - 1);

        return arr[a][b][c];
    }

}