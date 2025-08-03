package programmers;

public class pro239 {

    public static void main(String[] args) {

        String[] arr = {"1", "-", "3", "+", "5", "-", "8"};

        solution(arr);

    }

    public static int solution(String arr[]) {

        int n = (arr.length + 1) / 2;
        num = new int[n];
        maxDp = new Integer[n][n];
        minDp = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(arr[i * 2]);
        }

        return getMax(0, n - 1, arr);
    }

    static int[] num;
    static Integer[][] maxDp;
    static Integer[][] minDp;

    static int getMax(int left, int right, String[] arr) {
        if (maxDp[left][right] != null)
            return maxDp[left][right];

        if (left == right) {
            maxDp[left][right] = num[left];
            minDp[left][right] = num[left];
            return maxDp[left][right];
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = left; i < right; i++) {
            String operation = arr[i * 2 + 1];

            int leftMax = getMax(left, i, arr);
            int leftMin = getMin(left, i, arr);
            int rightMax = getMax(i + 1, right, arr);
            int rightMin = getMin(i + 1, right, arr);

            if ("+".equals(operation)) {
                max = Math.max(max, leftMax + rightMax);
                min = Math.min(min, leftMin + rightMin);
            } else {
                max = Math.max(max, leftMax - rightMin);
                min = Math.min(min, leftMin - rightMax);
            }
        }

        maxDp[left][right] = max;
        minDp[left][right] = min;

        return max;

    }

    static int getMin(int left, int right, String[] arr) {
        if (minDp[left][right] != null)
            return minDp[left][right];
        getMax(left, right, arr);
        return minDp[left][right];
    }

}
