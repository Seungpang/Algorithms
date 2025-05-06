package BJ;
// 최대공약수

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No2824 {

    static final int MOD = 1000000000;
    static Map<Integer, Integer> factorsA = new HashMap<>();
    static Map<Integer, Integer> factorsB = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            addFactors(factorsA, sc.nextInt());
        }

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            addFactors(factorsB, sc.nextInt());
        }

        long result = 1;
        boolean overflow = false;

        for (int factor : factorsA.keySet()) {
            if (factorsB.containsKey(factor)) {
                int power = Math.min(factorsA.get(factor), factorsB.get(factor));
                for (int i = 0; i < power; i++) {
                    result *= factor;
                    if (result >= MOD) {
                        result %= MOD;
                        overflow = true;
                    }
                }
            }
        }

        System.out.println(overflow ? String.format("%09d", result) : result);
    }

    static void addFactors(Map<Integer, Integer> factors, int n) {
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n > 1) {
            factors.put(n, factors.getOrDefault(n, 0) + 1);
        }
    }
}
