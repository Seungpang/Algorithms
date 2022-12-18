package codingInterview;

public class LC424 {

    public static void main(String[] args) {
        final LC424 lc424 = new LC424();
        System.out.println(lc424.characterReplacement("ABCASDGSDFAASDFSEWSDVCASAFDFVB", 4));//4
    }

    public int characterReplacement(String s, int k) {
        // count하는 배열 A~Z을 만든다.
        int[] count = new int[26];
        int n = s.length();
        int maxFrequency = 0;
        int left = 0;
        //반복문을 돌면서
        for (int right = 0; right < n; right++) {
            maxFrequency = Math.max(maxFrequency, ++count[s.charAt(right) - 'A']);
            if (right - left + 1 > maxFrequency + k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return n - left;
    }
}
