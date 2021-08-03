package LeetCode;

public class Implement_strStr {

    public static void main(String[] args) {
        Implement_strStr a = new Implement_strStr();
        String haystack = "hello";
        String needle = "bba";

        System.out.println(a.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        int len = needle.length();

        for (int i = 0; i < haystack.length() - len + 1; i++) {
            String sub = haystack.substring(i, i + len);

            if (sub.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
