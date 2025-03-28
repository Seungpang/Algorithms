package BJ;
// 소수

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No2581 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        List<Integer> primes = new ArrayList<>();
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < primes.size(); i++) {
            sum += primes.get(i);
            min = Math.min(min, primes.get(i));
        }
        if (primes.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
