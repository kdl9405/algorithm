
import java.util.*;
import java.util.Map.Entry;

public class pro1 {
    public static void main(String[] args) {

        String[] participant = { "mislav", "stanko", "mislav", "ana" };
        String[] completion = { "stanko", "ana", "mislav" };

        HashMap<String, Integer> hm = new HashMap<>();
            for (String element : participant) {
                hm.put(element, hm.getOrDefault(element, 0) + 1);
            }
            System.out.println(hm.toString());

        // System.out.println(person(participant, completion));
    }

    static String person(String[] participant, String[] completion) {

        String answer = "";
		HashMap<String, Integer> map = new HashMap<>();

		// participant 배열의 모든 값을 해시 맵에 넣어줌
		for (String part : participant) {

			// key = 문자열, value = 현재 맵에 저장된 문자열 갯수에 + 1
			map.put(part, map.getOrDefault(part, 0) + 1);
		}

		// completion 배열의 모든 값을 해시 맵에 넣어줌
		for (String comp : completion) {

			// 같은 문자열을 찾아 value의 값을 -1해줌
			map.put(comp, map.get(comp) - 1);
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 0) {
				answer = entry.getKey();
				break;
			}
		}
		return answer;
	}
}
