package codingInterview;

import java.util.Arrays;

public class LC942 {

    public static void main(String[] args) {
        final LC942 lc942 = new LC942();
        System.out.println(Arrays.toString(lc942.diStringMatch("IDID")));
    }

    public int[] diStringMatch(String s) {
        int n = s.length();
        int left = 0;
        int right = n;
        int[] result = new int[n + 1];
        for (int i = 0; i < n; i++) {
            result[i] = s.charAt(i) == 'I' ? left++ : right--;
        }
        result[n] = right;
        return result;
    }
}
