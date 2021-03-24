package BOJ;

import java.io.*;
import java.util.*;

/* 
    승부 예측

    // 6경기에 대한 승무패를 모두 구하여 6^3 경우의 수에 대한 확률을 누적.
    // 18가지 경우의 수에 대해서, 각 경우마다 확률*승점으로 각 팀의 최종 승점을 구하고 진출 확률을 구함.
    // 그리고 진출확률 18개를 모두 더해 18로 나누고 최종 진출확률을 산출?
*/

public class BOJ15997 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> TeamIdx = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            TeamIdx.put(st.nextToken(), i);
        }

        maches = new double[6][5];

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int A = TeamIdx.get(st.nextToken());
            int B = TeamIdx.get(st.nextToken());
            double w = Double.valueOf(st.nextToken());
            double d = Double.valueOf(st.nextToken());
            double l = Double.valueOf(st.nextToken());

            maches[i][0] = (double) A;
            maches[i][1] = (double) B;
            maches[i][2] = w;
            maches[i][3] = d;
            maches[i][4] = l;

        }

        result = new double[4];
        point = new int[4];

        count = 0;
        playMaches(0, (double) 1);

        for (double r : result) {
            System.out.println(String.format("%.10f", r));
        }

    }

    static double[][] maches;
    static double[] result;
    static int[] point;
    static int count;

    static void playMaches(int depth, double probability) {

        if (probability == 0) {
            return;
        }

        if (depth > 5) {
            toProbability(point, probability);
            return;
        }

        int A = (int) maches[depth][0];
        int B = (int) maches[depth][1];

        // A승리
        point[A] += 3;
        playMaches(depth + 1, probability * maches[depth][2]);
        point[A] -= 3;

        // B승리
        point[B] += 3;
        playMaches(depth + 1, probability * maches[depth][4]);
        point[B] -= 3;

        // 무승부
        point[A] += 1;
        point[B] += 1;
        playMaches(depth + 1, probability * maches[depth][3]);
        point[A] -= 1;
        point[B] -= 1;

    }

    static void toProbability(int[] point, double prob) {
        HashMap<Integer, Integer> pointTable = new HashMap<>();
        HashMap<Integer, Double> probability = new HashMap<>();

        for (int p : point) {
            pointTable.put(p, pointTable.getOrDefault(p, 0) + 1);
        }

        int[] pointGroup = pointTable.keySet().stream().mapToInt(i -> i).toArray();

        Arrays.sort(pointGroup);

        int chance = 2;
        for (int i = pointGroup.length - 1; i >= 0; i--) {
            if (chance >= pointTable.get(pointGroup[i])) {
                chance -= pointTable.get(pointGroup[i]);
                probability.put(pointGroup[i], (double) 1 * prob);
            } else if (chance == 0) {
                probability.put(pointGroup[i], (double) 0);
            } else {
                probability.put(pointGroup[i], ((double) chance / pointTable.get(pointGroup[i])) * prob);
                chance = 0;
            }
        }

        for (int i = 0; i < 4; i++) {
            result[i] += probability.get(point[i]);
        }
    }

}