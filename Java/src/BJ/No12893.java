package BJ;
// 적의 적

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No12893 {
    static List<Integer>[] graph;
    static int[] color;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList[n + 1];
        color = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            color[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean isBipartite = true;
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0)) {
                    isBipartite = false;
                    break;
                }
            }
        }

        System.out.println(isBipartite ? 1 : 0);
    }

    static boolean dfs(int node, int c) {
        color[node] = c;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == -1) {
                if (!dfs(neighbor, 1 - c)) {
                    return false;
                }
            } else if (color[neighbor] == c) {
                return false;
            }
        }

        return true;
    }
}
