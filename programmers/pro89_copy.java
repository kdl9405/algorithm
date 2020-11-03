import java.util.*;

/**
 * 외벽 점검
 * // 거리를 나누는 과정 중 max 값이 맨 앞이나 끝에 위치할 시,
 * 큐를 두 부분으로 나눈 부분 해결 못함...
 */
public class pro89_copy {

    public static void main(String[] args) {

        int[] weak = { 0, 3, 11, 21 };
        int[] dist = { 4, 10 };
        int n = 30;

        System.out.println(solution(n, weak, dist));

    }

    static int solution(int n, int[] weak, int[] dist) {
        int answer = -1;

        if (weak.length == 1) {
            return 1;
        }

        int[] arr = new int[weak.length];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < weak.length - 1; i++) {
            arr[i] = weak[i + 1] - weak[i];
            queue.offer(arr[i]);
        }

        arr[weak.length - 1] = weak[0] + (n - weak[weak.length - 1]);
        queue.offer(arr[weak.length - 1]);
        Integer[] max = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(max, Collections.reverseOrder());

        int count = 1;

        while (count <= dist.length) {

            System.out.println("count     " + count + "     queue     " + queue);

            Queue<Integer> temp = new LinkedList<>();
            temp.addAll(queue);

            int[] list = new int[count];
            int i = 0;
            while (temp.peek() != max[i]) {
                temp.offer(temp.poll());
            }

            System.out.println("sort temp     " + temp);

            int j = -1;
            while (!temp.isEmpty()) {

                System.out.println("j     " + j + "     temp     " + temp);

                if (j == count - 1) {

                    while (!temp.isEmpty()) {
                        list[j] += temp.poll();
                    }
                    break;
                }

                if (temp.peek() != max[j + 1]) {
                    list[j] += temp.poll();

                } else {
                    temp.poll();
                    j++;
                }
            }

            Arrays.sort(list);

            for (int x = 0; x < list.length; x++) {
                System.out.println(x + "    " + list[x]);
            }

            boolean check = true;
            for (j = 1; j <= list.length; j++) {

                if (list[list.length - j] > dist[dist.length - 1]) {
                    check = false;
                    break;
                }
            }

            if (check == false) {
                count++;
            } else {
                answer = count;
                break;
            }

        }

        return answer;
    }
}