package programmers;

/* 
    호텔 방 배정

*/

import java.util.*;

public class pro227 {

    public static void main(String[] args) {
        long k = 10;
        long[] room_number = { 1, 3, 4, 1, 3, 1 };

        long[] answer = solution(k, room_number);

        for (int i = 0; i < room_number.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        HashMap<Long, Long> next_room = new HashMap<>();

        for (int i = 0; i < room_number.length; i++) {

            if (!next_room.containsKey(room_number[i])) {
                answer[i] = room_number[i];
                next_room.put(room_number[i], room_number[i] + 1);
            } else {

                ArrayList<Long> used_room = new ArrayList<>();
                used_room.add(room_number[i]);

                long room = next_room.get(room_number[i]);
                while (next_room.containsKey(room)) {
                    used_room.add(room);
                    room = next_room.get(room);
                }

                answer[i] = room;

                used_room.add(room);
                for (Long r : used_room) {
                    next_room.put(r, room + 1);
                }

            }
        }

        return answer;
    }
}
