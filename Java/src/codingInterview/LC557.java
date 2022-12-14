package codingInterview;

public class LC557 {

    public static void main(String[] args) {
        final LC557 lc557 = new LC557();
        System.out.println(lc557.reverseWords("Let's take LeetCode contest"));
        //"s'teL ekat edoCteeL tsetnoc"
    }

    public String reverseWords(String s) {
        int n = s.length();
        int lastWordIndex = -1;
        final char[] words = s.toCharArray();
        for (int wordIndex = 0; wordIndex <= n; wordIndex++) {
            if (wordIndex == n || words[wordIndex] == ' ') {
                int startIndex = lastWordIndex + 1;
                int endIndex = wordIndex - 1;
                while (startIndex < endIndex) {
                    char temp = words[startIndex];
                    words[startIndex] = words[endIndex];
                    words[endIndex] = temp;
                    startIndex++;
                    endIndex--;
                }
                lastWordIndex = wordIndex;
            }
        }
        return new String(words);
    }
}
