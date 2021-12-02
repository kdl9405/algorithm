package softeer.coding;

import java.io.*;
import java.util.*;

public class sol3 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] cow = new int[N][2];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cow[i][0] = Integer.parseInt(st.nextToken());
            cow[i][1] = Integer.parseInt(st.nextToken());
        }

        int dis = 1000001;

        for (int i = 0; i < N - 1; i++) {
            if ((cow[i][1] == 1 && cow[i + 1][1] == 0) || cow[i][1] == 0 && cow[i + 1][1] == 1) {
                dis = Math.min(dis, cow[i + 1][0] - cow[i][0] - 1);
            }
        }

        System.out.println("!!" + dis);

        int answer = 0;

        int point = 0;

        boolean check = false;

        for (int i = 0; i < N; i++) {

            if (cow[i][1] == 1) {

                if (!check) {

                    point = cow[i][0];
                    answer++;

                    check = true;

                    i++;
                    for (; i < N; i++) {
                        if (cow[i][1] == 0) {
                            check = false;
                            i--;
                            break;
                        }
                        if (cow[i][0] > point + dis) {
                            i--;
                            break;
                        }
                    }

                    // if (point == cow[i][0]) {
                    //     // point = cow[i][0];
                    //     check = false;
                    // }

                } else {

                    for (int j = i + 1; j < N; j++) {
                        if (cow[j][0] > point + dis) {
                            i = j - 1;
                            break;
                        }

                        check = false;
                    }

                }
            } else {
                check = false;
            }

            System.out.println(i + " " + check + " " + answer + " " + point);

            // if (cow[i][1] == 0) {
            // check = false;
            // }else{

            // if (!check) {
            // answer++;
            // check = true;
            // }else{
            // if (cow[i][0] > point+dis) {
            // answer++;
            // }
            // }

            // point = cow[i][0];
            // }
        }

        System.out.println(answer);

    }
}
