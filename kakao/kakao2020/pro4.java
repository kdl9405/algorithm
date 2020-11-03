package kakao.kakao2020;

public class pro4 {

    public static void main(final String[] args) {

        int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
        int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

        System.out.println(solution(key, lock));

    }

    static boolean solution(int[][] key, int[][] lock) {
        int len = lock.length;
        int kelen = key.length;
        int lockCount = 0;
        int keyCount = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (lock[i][j] == 0) {
                    lockCount++;
                }
            }
        }

        if (lockCount == 0) {
            return true;
        }

        for (int i = 0; i < kelen; i++) {
            for (int j = 0; j < kelen; j++) {
                if (key[i][j] == 1) {
                    keyCount++;
                }
            }
        }

        int[][] lockpo = new int[lockCount][2];
        int[][] key1po = new int[keyCount][2];
        int[][] key2po = new int[keyCount][2];
        int[][] key3po = new int[keyCount][2];
        int[][] key4po = new int[keyCount][2];

        lockCount = 0;
        keyCount = 0;

        for (int i = 0; i < kelen; i++) {
            for (int j = 0; j < kelen; j++) {
                
                if (key[i][j] == 1) {
                    key1po[keyCount][0] = i;
                    key1po[keyCount][1] = j;

                    key2po[keyCount][0] = len - 1 - j;
                    key2po[keyCount][1] = i;

                    key3po[keyCount][0] = len - 1 - i;
                    key3po[keyCount][1] = len - 1 - j;

                    key4po[keyCount][0] = j;
                    key4po[keyCount][1] = len - 1 - i;

                    keyCount++;

                }

            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {

                if (lock[i][j] == 0) {
                    lockpo[lockCount][0] = i;
                    lockpo[lockCount][1] = j;
                    lockCount++;
                }

            }
        }

        if (check(key1po, lockpo, len,kelen)) {
            return true;
        } else if (check(key2po, lockpo, len,kelen)) {
            return true;
        } else if (check(key3po, lockpo, len,kelen)) {
            return true;
        } else if (check(key4po, lockpo, len,kelen)) {
            return true;
        }

        return false;
    }

    static boolean check(int[][] keyPo, int[][] lockPo, int len, int kelen) {

        for (int n = 0; n < keyPo.length; n++) {

            for (int i = 0; i < lockPo.length; i++) {

                int x = lockPo[i][0] - keyPo[n][0];
                int y = lockPo[i][1] - keyPo[n][1];

                for (int[] po : keyPo) {
                    po[0] += x;
                    po[1] += y;
                }

                int count = 0;
                for (int[] po : lockPo) {
                    for (int a = 0; a < keyPo.length; a++) {
                        if (po[0] == keyPo[a][0] && po[1] == keyPo[a][1]) {
                            count++;
                            break;
                        }
                    }
                }

                if (count == lockPo.length) {
                    count = 0;
                    for (int[] po : keyPo) {
                        if (po[0] < 0 || po[0] >= len || po[1] < 0 || po[1] >= len) {
                            count++;
                        }
                    }

                    if (count == keyPo.length - lockPo.length) {
                        return true;
                    }
                }

            }
        }

        return false;
    }
}
