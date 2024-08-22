package BJ;
// 즐거운 단어

import java.util.Arrays;
import java.util.Scanner;

public class No2922 {

    static char[] word;
    static long[][][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        word = sc.next().toCharArray();
        int n = word.length;

        dp = new long[n][3][3][2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                    Arrays.fill(dp[i][j][k], -1);

        System.out.println(countHappyWords(0, 0, 0, 0));
    }

    static long countHappyWords(int index, int vowelCount, int consonantCount, int hasL) {
        if (vowelCount == 3 || consonantCount == 3) {
            return 0;
        }
        if (index == word.length) {
            return hasL;
        }

        if (dp[index][vowelCount][consonantCount][hasL] != -1) {
            return dp[index][vowelCount][consonantCount][hasL];
        }

        long result = 0;
        if (word[index] == '_') {
            result += 5 * countHappyWords(index + 1, vowelCount + 1, 0, hasL);
            result += 20 * countHappyWords(index + 1, 0, consonantCount + 1, hasL);
            result += countHappyWords(index + 1, 0, consonantCount + 1, 1);
        } else {
            if ("AEIOU".indexOf(word[index]) != -1) {
                result = countHappyWords(index + 1, vowelCount + 1, 0, hasL);
            } else {
                result = countHappyWords(index + 1, 0, consonantCount + 1, hasL | (word[index] == 'L' ? 1 : 0));
            }
        }

        return dp[index][vowelCount][consonantCount][hasL] = result;
    }
}
