import java.util.Arrays;

/**
 * [1차] 추석 트래픽
 */
public class pro78 {

    public static void main(String[] args) {

        String[] lines = { "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s" };

        System.out.println(solution(lines));

    }

    static int solution(String[] lines) {
        int answer = 0;

        double[][] times = time(lines);

        Arrays.sort(times, (t1, t2) -> {
            return (int) (t1[0] * 100) - (int) (t2[0] * 100);
        });

        for (int i = 0; i < times.length; i++) {
            double startS = times[i][1];
            double endS = times[i][1] + 1.0 ;

            System.out.println("start  : "+startS +"  end : " + endS);

            int count = 1;
            for (int j = 0; j < times.length; j++) {      
                
                System.out.println("j0  : "+times[j][0] +"  j1 : " + times[j][1]);

                if (times[j][0] < endS && times[j][1] > startS) {
                    count++;
                }
                if (times[j][0] >=endS) {
                    break;
                }
            }
            answer = Math.max(answer, count);

        }

        for(double[] d : times){
            System.out.println(d[0] +"   " + d[1]);
        }

        return answer;
    }

    static double[][] time(String[] lines) {

        double[][] T = new double[lines.length][2];

        for (int i = 0; i < lines.length; i++) {

            String[] str = lines[i].split(" ");
            str[2] = str[2].replaceAll("s", "");
            String[] endT = str[1].split(":");

            T[i][1] = Integer.parseInt(endT[0]) * 60 + Integer.parseInt(endT[1]);
            T[i][1] = (T[i][1] * 60 + Double.parseDouble(endT[2]));
            T[i][0] = ((T[i][1] - Double.parseDouble(str[2]))*1000+1)/1000.0;
        }

        return T;
    }
}