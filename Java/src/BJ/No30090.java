package BJ;
// 백신 개발

import java.util.Scanner;

public class No30090 {

    static int N;
    static String[] arr;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;
//    static int min = Integer.MAX_VALUE;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        N = Integer.parseInt(sc.nextLine());
//        String[] arr = new String[N];
//        for (int i = 0; i < N; i++) {
//            arr[i] = sc.nextLine();
//        }
//
//        int[][] add = new int[N][N];
//        int[] len = new int[N];
//        for (int i = 0; i < N; i++) {
//            len[i] = arr[i].length();
//        }
//
//        for (int i=0; i<N; i++) {
//            for (int j=0; j<N; j++) {
//                if (i == j) {
//                    add[i][j] = len[j];
//                    continue;
//                }
//
//                int num = overlap(arr[i], arr[j]);
//                add[i][j] = len[j] - num;
//            }
//        }
//
//        int FULL = 1 << N;
//        int[][] dp = new int[FULL][N];
//        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
//
//        for (int i = 0; i < N; i++) {
//            dp[1 << i][i] = len[i];
//        }
//
//        for (int mask = 0; mask < FULL; mask++) {
//            for (int last = 0; last < N; last++) {
//                if (dp[mask][last] == Integer.MAX_VALUE) continue;
//                for (int nxt = 0; nxt < N; nxt++) {
//                    if ((mask & (1 << nxt)) != 0) continue; // 이미 사용
//                    int nmask = mask | (1 << nxt);
//                    dp[nmask][nxt] = Math.min(dp[nmask][nxt], dp[mask][last] + add[last][nxt]);
//                }
//            }
//        }
//
//        int ans = Integer.MAX_VALUE;
//        for (int last = 0; last < N; last++) ans = Math.min(ans, dp[FULL - 1][last]);
//        System.out.println(ans);
//    }
//
//    static int overlap(String s, String t) {
//        int max = Math.min(s.length(), t.length());
//        for (int k = max; k >= 0; k--) {
//            if (s.regionMatches(s.length() - k, t, 0, k)) return k;
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
        }

        visited = new boolean[N];

        dfs(0, "");
        System.out.println(ans);
    }

    private static void dfs(int depth, String cur) {
        if (depth == N) {
            ans = Math.min(ans, cur.length());
            return;
        }

        if (cur.length() >= ans) return;

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            String next = makeStr(arr[i], cur);
            dfs(depth + 1, next);
            visited[i] = false;
        }
    }

    private static String makeStr(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        for (int i = lenA; i >= 0; i--) {
            if (i > lenB) continue;

            if (b.regionMatches(lenB - i, a, 0, i)) {
                return b + a.substring(i);
            }
        }

        return a + b;
    }
}
