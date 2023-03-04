package BJ;
//그래프
//이분 그래프

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No1707 {
    static List<Integer>[] a;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int t = 0; t < testCase; t++) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            a = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            IsEven = true;
            for (int i = 1; i <= V; i++) {
                a[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                a[start].add(end);
                a[end].add(start);
            }

            for (int i = 1; i <= V; i++) {
                if (IsEven) {
                    dfs(i);
                } else {
                    break;
                }
            }

            if (IsEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void dfs(int start) {
        visited[start] = true;
        for (int i : a[start]) {
            if (!visited[i]) {
                check[i] = (check[start] + 1) % 2;
                dfs(i);
            } else if (check[start] == check[i]) {
                IsEven = false;
            }
        }
    }
}
