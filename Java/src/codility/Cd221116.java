package codility;

public class Cd221116 {

    public static void main(String[] args) {
        final Cd221116 cd221116 = new Cd221116();
        String s1 = "aabacbba";
        System.out.println(cd221116.solution(s1)); // 6

        String s2 = "aabxbaba";
        System.out.println(cd221116.solution(s2)); // 6

        String s3 = "xxxyxxyyyxyyy";
        System.out.println(cd221116.solution(s3)); // 11

        String s4 = "atheaxbtheb";
        System.out.println(cd221116.solution(s4)); // 5
    }

    public int solution(String S) {
        // write your code in Java SE 8
        int n = S.length();
        int blockCondition = 3;

        if (n <= blockCondition) {
            return n;
        }

        int[] m = new int[blockCondition + 1];
        int[][] dp = new int[blockCondition + 1][26];

        int result = 3;
        for (char d : S.toCharArray()) {
            int x = d - 'a';
            for (int i = blockCondition; i > 0; i--) {
                dp[i][x] = Math.max(dp[i][x] + 1, m[i - 1] + 1);
                m[i] = Math.max(m[i], dp[i][x]);
            }
            result = Math.max(result, m[blockCondition]);
        }
        return result;
    }
}

