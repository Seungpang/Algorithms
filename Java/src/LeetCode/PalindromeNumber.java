package LeetCode;

public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber a = new PalindromeNumber();
        int x = 121;
        System.out.println(a.isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        String a = String.valueOf(x);

        for (int i = 0; i < a.length() / 2; i++) {
            if (!(a.charAt(i) == a.charAt(a.length() - 1 - i)))
                return false;
        }
        return true;
    }
}
