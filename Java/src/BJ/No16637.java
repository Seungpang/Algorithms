package BJ;
// 괄호 추가하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No16637 {
    static int N;
    static char[] expr;
    static long max = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        expr = br.readLine().toCharArray();

        dfs(0, Long.parseLong(String.valueOf(expr[0])));
        System.out.println(max);
    }

    static void dfs(int idx, long current) {
        if (idx >= N - 1) {
            max = Math.max(max, current);
            return;
        }

        char op = expr[idx + 1];
        long nextNum = Long.parseLong(String.valueOf(expr[idx + 2]));

        long result = calc(current, nextNum, op);
        dfs(idx + 2, result);

        if (idx + 4 <= N - 1) {
            char nextOp = expr[idx + 3];
            long nextNextNum = Long.parseLong(String.valueOf(expr[idx + 4]));

            long bracketResult = calc(nextNum, nextNextNum, nextOp);
            long totalResult = calc(current, bracketResult, op);

            dfs(idx + 4, totalResult);
        }
    }

    static long calc(long a, long b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 0;
    }
}
