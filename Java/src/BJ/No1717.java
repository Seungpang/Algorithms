package BJ;
//유니온 파인드
//집합의 표현

import java.util.Scanner;

public class No1717 {

    private static int[] parent;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int question = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (question == 0) {
                union(x, y);
            } else {
                if (isSame(x, y)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    private static int find(final int x) {
        if (x == parent[x]) {
            return x;
        }  else {
            return parent[x] = find(parent[x]);
        }
    }

    private static boolean isSame(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }
}
