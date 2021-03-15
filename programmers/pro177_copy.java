package programmers;

import java.util.*;

/*
    선입 선출 스케줄링

    정확도도 통과 못함 시브링너ㅔㄹ
*/
public class pro177_copy {

    public static void main(String[] args) {
        int n = 10;
        int[] cores = { 2, 10, 1, 5 };

        System.out.println(solution(n, cores));
    }

    static class Core {
        int index;
        int time;

        public Core(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

    static int solution(int n, int[] cores) {
        int answer = 0;
        ArrayList<Core> list = new ArrayList<>();
        for (int i = 0; i < cores.length; i++) {
            list.add(new Core(i + 1, cores[i]));
            n -= 1;
        }

        boolean over = true;
        while (over) {
            for (Core core : list) {
                core.time--;

                if (core.time == 0) {
                    System.out.println(core.index+"번 코어"+" 남은 작업 = "+ n);
                    n--;
                    answer = core.index;
                    list.set(core.index - 1, new Core(core.index, cores[core.index - 1]));

                    if (n == 0) {
                        over = false;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}