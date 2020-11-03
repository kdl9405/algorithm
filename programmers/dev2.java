public class dev2 {    
    public static void main(String[] args) {
        String p = "PM 12:01:00";

        int n = 1;

        System.out.println(solution(p, n));
    }

    static String solution(String p, int n) {
        String answer = null;
        
        String[] str = p.split(" ");
        String[] time = str[1].split(":");

        if (str[0].equals("PM") && !time[0].equals("12")) {
            time[0] = Integer.toString(Integer.parseInt(time[0])+12);
        }
        if (str[0].equals("AM") && time[0].equals("12")) {
            time[0] = "0";
        }

        System.out.println(time[0]);

        int temp = Integer.parseInt(time[2]) + n;
        time[2] = Integer.toString((temp % 60));
        temp = temp/60 + Integer.parseInt(time[1]);
        time[1] = Integer.toString((temp % 60));
        temp = temp/60 + Integer.parseInt(time[0]);
        time[0] = Integer.toString((temp%24));

        for(int i = 0; i<3; i++){
            if (time[i].length()<2) {
                time[i] = "0"+time[i];
            }
        }

        answer = time[0]+":"+time[1]+":"+time[2];

        return answer;
    }
}

