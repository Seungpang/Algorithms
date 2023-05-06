package BJ;
//가장 가까운 공통 조상
//LCA

import java.util.Scanner;

public class No3584 {

    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            parent = new int[n + 1];
            visited = new boolean[n + 1];
            for (int i = 1; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                parent[y] = x;
            }

            int a = sc.nextInt();
            int b = sc.nextInt();
            excuteLCA(a, b);
        }


    }

    static void excuteLCA(int a, int b) {
        while (a > 0) {
            visited[a] = true;
            a = parent[a];
        }
        while (b > 0) {
            if (visited[b]) {
                System.out.println(b);
                break;
            }
            b = parent[b];
        }
    }
}
