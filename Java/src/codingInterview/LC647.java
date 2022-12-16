package codingInterview;

public class LC647 {

    public static void main(String[] args) {
        final LC647 lc647 = new LC647();
        System.out.println(lc647.countSubstrings1("aaa"));
        System.out.println(lc647.countSubstrings2("aaa"));
        //6
    }

    public int countSubstrings1(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += countPalindromicAroundCenter(s, i, i);
            result += countPalindromicAroundCenter(s, i, i+1);
        }
        return result;
    }

    private int countPalindromicAroundCenter(final String s, int low, int high) {
        int result = 0;

        while (low >= 0 && high < s.length()) {
            if (s.charAt(low) != s.charAt(high)) break;
            low--;
            high++;
            result++;
        }
        return result;
    }

    public int countSubstrings2(String s) {
        int result = 0;
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                result += isPalindrome(s, start, end) ? 1 : 0;
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
