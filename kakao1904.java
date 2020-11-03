import java.util.*;

/**
 * kakao1904
 */
public class kakao1904 {

    public static void main(String[] args) {

        long k = 10;
        long[] room_number = { 1, 3, 4, 1, 3, 1 };

        long[] answer = solution(k, room_number);

        for (int i = 0; i < room_number.length; i++) {
            System.out.println(answer[i]);
        }

    }

    public static long[] solution(long k, long[] room_number) {
        long[] answer = {};
        int n = room_number.length;
        answer = new long[n];

        HashMap<Long, Long> room = new HashMap<>();

        for (int i = 0; i < n; i++) {

            ArrayList<Long> list = new ArrayList<>();
            long x = room_number[i];
            list.add(x);

            if (!room.containsKey(x)) {
                answer[i] = x;
                room.put(x, x + 1);
            } else {

                long y = room.get(x);
                list.add(x);

                while (true) {
                    if (!room.containsKey(y)) {
                        answer[i] = y;
                        room.put(y, y + 1);
                        break;
                    }else{
                        list.add(y);
                        y = room.get(y);
                    }
                }

                for (long l : list){
                    room.put(l, y+1);
                }

            }

        }

        return answer;
    }

}