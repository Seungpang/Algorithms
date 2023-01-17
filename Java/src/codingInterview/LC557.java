package codingInterview;

public class LC557 {

    public static void main(String[] args) {
        final LC557 lc557 = new LC557();
        System.out.println(lc557.reverseWords("Let's take LeetCode contest"));
        //"s'teL ekat edoCteeL tsetnoc"
    }

    public String reverseWords(String s) {
        int n = s.length();
        int lastStrIndex = -1;
        char[] words = s.toCharArray();
        for (int strIndex = 0; strIndex < n; strIndex++) {
            if (strIndex == n || words[strIndex] == ' ') {
                int startIndex = lastStrIndex + 1;
                int endIndex = strIndex - 1;
                while (startIndex < endIndex) {
                    char temp = words[startIndex];
                    words[startIndex] = words[endIndex];
                    words[endIndex] = temp;
                    startIndex++;
                    endIndex--;
                }
                lastStrIndex = strIndex;
            }
        }
        return new String(words);
    }
}
