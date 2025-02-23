package reetcode;

public class reet26 {

    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {

        int count = 1;
        int x = 1;


        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] != nums[i]) {
                nums[x++] = nums[i];
                count++;
            }
        }

        return count;
    }
}
