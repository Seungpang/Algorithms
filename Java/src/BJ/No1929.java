package BJ;

import java.util.Scanner;

public class No1929 {

    public static boolean[] prime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        prime = new boolean[end + 1];
        getPrime();

        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (!prime[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static void getPrime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
