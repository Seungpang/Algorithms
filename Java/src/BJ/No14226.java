package BJ;
//bfs
//이모티콘

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//
//class Pair {
//    int x, y;
//    Pair(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}

public class No14226 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], -1);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 0));
        dist[1][0] = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            if (dist[x][x] == -1) {
                dist[x][x] = dist[x][y] + 1;
                q.add(new Pair(x, x));
            }
            if (x + y <= n && dist[x + y][y] == -1) {
                dist[x + y][y] = dist[x][y] + 1;
                q.add(new Pair(x + y, y));
            }
            if (x - 1 >= 0 && dist[x - 1][y] == -1) {
                dist[x - 1][y] = dist[x][y] + 1;
                q.add(new Pair(x - 1, y));
            }
        }
        int result = -1;
        for (int i = 0; i <= n; i++) {
            if (dist[n][i] != -1) {
                if (result == -1 || result > dist[n][i]) {
                    result = dist[n][i];
                }
            }
        }
        System.out.println(result);
    }
}
