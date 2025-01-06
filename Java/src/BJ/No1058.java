package BJ;
// 친구

import java.util.Scanner;

public class No1058 {

    static final int INF = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else if (line.charAt(j) == 'Y') {
                    dist[i][j] = 1;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                }
            }
        }

        int maxFriends = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i != j && dist[i][j] <= 2) {
                    count++;
                }
            }

            maxFriends = Math.max(maxFriends, count);
        }
        System.out.println(maxFriends);
    }
}
