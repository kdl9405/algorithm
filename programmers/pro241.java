package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pro241 {


    public int[] solution(String today, String[] terms, String[] privacies) {

        var termMap = getTermMap(terms);

        List<Integer> expiredList = new ArrayList<>();
        int index = 1;
        for (String privacy : privacies) {
            String[] privacyArray = privacy.split(" ");

            if (termMap.containsKey(privacyArray[1])) {
                if (isExpired(today, privacyArray[0], termMap.get(privacyArray[1]))) {
                    expiredList.add(index);
                }
            }

            index++;
        }

        return expiredList.stream().mapToInt(Integer::intValue).toArray();
    }

    private Map<String, Integer> getTermMap(String[] terms) {
        var termMap = new HashMap<String, Integer>();

        for (String term : terms) {
            String[] termArray = term.split(" ");

            termMap.put(termArray[0], Integer.valueOf(termArray[1]));
        }

        return termMap;
    }

    private boolean isExpired(String today, String firstDay, int month) {

        int[] todayDate = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] expiredDate =
                Arrays.stream(firstDay.split("\\.")).mapToInt(Integer::parseInt).toArray();
        expiredDate[1] += month;
        if (expiredDate[1] > 12) {
            expiredDate[1] -= 12;
            expiredDate[0] += 1;
        }

        if (todayDate[0] < expiredDate[0]) {
            return false;
        }

        if (todayDate[0] == expiredDate[0]) {
            if (todayDate[1] < expiredDate[1])
                return false;

            if (todayDate[1] > expiredDate[1])
                return true;
        }

        return todayDate[2] <= expiredDate[2];
    }
}
