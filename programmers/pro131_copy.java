package programmers;


/* 
    순위 검색

    효율성 X
*/

public class pro131_copy {
    
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] answer = solution(info, query);

        for(int a : answer){
            System.out.println(a);
        }
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        String[][] infoArr = new String[info.length][5];
        int i = 0;
        for(String[] arr : infoArr){
            String[] str = info[i].split(" ");
            for(int j = 0; j<5; j++){
                arr[j] = str[j];
            }
            i++;
        }

        for(int j = 0; j<query.length; j++){
            String[] str = query[j].split(" ");

            int count = 0;
            loop:
            for(String[] arr : infoArr){
                for(i = 0; i<=6; i+=2){
                    if (str[i].equals("-")) {
                        continue;
                    }
                    if (!str[i].equals(arr[i/2])) {
                        continue loop;
                    }                    
                }
                if (Integer.parseInt(arr[4]) >= Integer.parseInt(str[7])) {
                    count++;
                }
            }

            answer[j] = count;
        }

        return answer;
    }
}
