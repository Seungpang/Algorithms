package BJ;
// 감소하는 수

import java.util.*;

public class No1038 {

    static List<Long> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        result = new ArrayList<>();

        if (n <= 10) {
            System.out.println(n);
        } else if (n > 1022) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < 10; i++) {
                go(1, i);
            }
            Collections.sort(result);
            System.out.println(result.get(n));
        }
    }

    static void go(int count, long num) {
        if (count > 10) {
            return;
        }
        result.add(num);

        for (int i = 0; i < num % 10; i++) {
            go(count + 1, (num * 10) + i);

        }
    }
}
