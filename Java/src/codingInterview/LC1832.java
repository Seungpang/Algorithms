package codingInterview;

public class LC1832 {

    public static void main(String[] args) {
        final LC1832 lc1832 = new LC1832();
        System.out.println(lc1832.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }

    public boolean checkIfPangram(String sentence) {
        for (int i=0; i<26; i++) {
            char currChar = (char) ('a' + i);

            if (sentence.indexOf(currChar) == -1) {
                return false;
            }
        }
        return true;
    }
}
