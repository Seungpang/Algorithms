package codility;

import java.util.Arrays;

public class Genomicrangequery {

    public static void main(String[] args) {
        final Genomicrangequery genomicrangequery = new Genomicrangequery();
        System.out.println(
                Arrays.toString(genomicrangequery.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
        //2, 4, 1
    }

    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int[] result = new int[P.length];

        int[] A = new int[S.length() + 1];
        int[] C = new int[S.length() + 1];
        int[] G = new int[S.length() + 1];
        int[] T = new int[S.length() + 1];

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'A') {
                A[i + 1] = A[i] + 1;
                C[i + 1] = C[i];
                G[i + 1] = G[i];
                T[i + 1] = T[i];
            } else if (S.charAt(i) == 'C') {
                A[i + 1] = A[i];
                C[i + 1] = C[i] + 1;
                G[i + 1] = G[i];
                T[i + 1] = T[i];
            } else if (S.charAt(i) == 'G') {
                A[i + 1] = A[i];
                C[i + 1] = C[i];
                G[i + 1] = G[i] + 1;
                T[i + 1] = T[i];
            } else if (S.charAt(i) == 'T') {
                A[i + 1] = A[i];
                C[i + 1] = C[i];
                G[i + 1] = G[i];
                T[i + 1] = T[i] + 1;
            }
        }

        for (int i = 0; i < P.length; i++) {
            int a = A[Q[i] + 1] - A[P[i]];
            int c = C[Q[i] + 1] - C[P[i]];
            int g = G[Q[i] + 1] - G[P[i]];

            if (a > 0) {
                result[i] = 1;
            } else if (c > 0) {
                result[i] = 2;
            } else if (g > 0) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;
    }
}
