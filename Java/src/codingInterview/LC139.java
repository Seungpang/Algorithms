package codingInterview;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139 {

    public static void main(String[] args) {
        final LC139 lc139 = new LC139();
        System.out.println(lc139.wordBreak("catsandog", List.of("cats","dog","sand","and","cat")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
