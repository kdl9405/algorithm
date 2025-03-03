package reetcode;

public class reet125 {

    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
    }

    public static boolean isPalindrome(String s) {

        var removedNonAlphanumericS = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = removedNonAlphanumericS.length() - 1;

        while (left < right) {
            if (removedNonAlphanumericS.charAt(left) != removedNonAlphanumericS.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

}
