package BJ;
// 부동산 다툼

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class No20364 {

    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int x = sc.nextInt();
            int cur = x;
            int blocked = 0;

            while (cur > 0) {
                if (set.contains(cur)) {
                    blocked = cur;
                }
                cur /= 2;
            }

            if (blocked == 0) {
                set.add(x);
            }

            sb.append(blocked).append("\n");
        }
        System.out.println(sb);
    }
}
