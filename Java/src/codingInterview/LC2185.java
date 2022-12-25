package codingInterview;

public class LC2185 {

    public static void main(String[] args) {
        final LC2185 lc2185 = new LC2185();
        System.out.println(lc2185.prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at"));
    }

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
                if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}
