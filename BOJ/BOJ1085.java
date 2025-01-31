package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1085 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int dx = 0, dy = 0;

        if (x <= (w - x)) {
            dx = x;
        } else {
            dx = w - x;
        }

        if (y <= (h - y)) {
            dy = y;
        } else {
            dy = h - y;
        }

        if (dx <= dy) {
            System.out.println(dx);
        } else {
            System.out.println(dy);
        }


    }
}
