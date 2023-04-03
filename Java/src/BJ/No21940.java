package BJ;
// 가운데에서 만나기
// 플로이드 워셜

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class No21940 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], 100001);
            dist[i][i] = 0;
        }

        while (m-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            dist[start][end] = Math.min(dist[start][end], value);
        }

        int f = sc.nextInt();
        int[] c = new int[f + 1];
        for (int i = 1; i <= f; i++) {
            c[i] = sc.nextInt();
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        List<Node> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int ci = 1; ci <= f; ci++) {
                max = Math.max(max, dist[i][c[ci]] + dist[c[ci]][i]);
            }
            result.add(new Node(max, i));
        }
        Collections.sort(result);

        int min = result.get(0).start;
        for (Node node : result) {
            if (min < node.start) {
                break;
            }
            System.out.print(node.end + " ");
        }
    }

    static class Node implements Comparable<Node> {
        int start, end;

        public Node(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(final Node o) {
            if (this.start < o.start) {
                return -1;
            } else if (this.start == o.start) {
                return this.end - o.end;
            } else {
                return 1;
            }
        }
    }
}
