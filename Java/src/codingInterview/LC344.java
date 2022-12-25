package codingInterview;

public class LC344 {

    public static void main(String[] args) {
        final LC344 lc344 = new LC344();
        System.out.println(lc344.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'}));
    }

    public char[] reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        return s;
    }
}
