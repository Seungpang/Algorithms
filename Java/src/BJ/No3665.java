package BJ;
// 최종 순위

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class No3665 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] team = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                team[i] = sc.nextInt();
            }

            boolean[][] adj = new boolean[n + 1][n + 1];
            int[] inDegree = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    int u = team[i];
                    int v = team[j];
                    adj[u][v] = true;
                    inDegree[v]++;
                }
            }

            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                if (adj[a][b]) {
                    adj[a][b] = false;
                    adj[b][a] = true;
                    inDegree[b]--;
                    inDegree[a]++;
                } else if (adj[b][a]) {
                    adj[b][a] = false;
                    adj[a][b] = true;
                    inDegree[a]--;
                    inDegree[b]++;
                } else {
                    System.out.println("IMPOSSIBLE");
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            boolean multiple = false;

            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            for (int i = 0; i < n; i++) {
                if (queue.isEmpty()) {
                    System.out.println("IMPOSSIBLE");
                    multiple = true;
                    break;
                }
                if (queue.size() > 1) {
                    multiple = true;
                }

                int u = queue.poll();
                result.add(u);

                for (int v = 1; v <= n; v++) {
                    if (adj[u][v]) {
                        inDegree[v]--;
                        if (inDegree[v] == 0) {
                            queue.offer(v);
                        }
                    }
                }
            }

            if (multiple && result.size() == n) {
                System.out.println("?");
            } else if (result.size() == n) {
                for (int i = 0; i < n; i++) {
                    System.out.print(result.get(i));
                    if (i != n - 1) System.out.print(" ");
                }
                System.out.println();
            } else if (!multiple) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
