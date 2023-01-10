package codingInterview;

public class LC944 {

    public static void main(String[] args) {
        final LC944 lc944 = new LC944();
        System.out.println(lc944.minDeletionSize(new String[]{"cba", "daf", "ghi"}));
    }

    public int minDeletionSize(String[] strs) {
        int count = 0;
        int wordLength = strs[0].length();
        for (int i = 0; i < wordLength; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) < strs[j-1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
