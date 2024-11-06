package BJ;
// 점프 게임

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No15558 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        String leftLine = sc.nextLine();
        String rightLine = sc.nextLine();

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[2][N];

        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int line = curr[0];
            int pos = curr[1];
            int time = curr[2];

            if (pos + 1 >= N) {
                System.out.println(1);
                return;
            }
            if (pos + 1 < N && !visited[line][pos + 1] &&
                pos + 1 > time && isSafe(line, pos + 1, leftLine, rightLine)) {
                visited[line][pos + 1] = true;
                q.offer(new int[]{line, pos + 1, time + 1});
            }

            if (pos - 1 >= 0 && !visited[line][pos - 1] &&
                pos - 1 > time && isSafe(line, pos - 1, leftLine, rightLine)) {
                visited[line][pos - 1] = true;
                q.offer(new int[]{line, pos - 1, time + 1});
            }

            int nextLine = 1 - line;
            if (pos + K >= N) {
                System.out.println(1);
                return;
            }
            if (pos + K < N && !visited[nextLine][pos + K] &&
                pos + K > time && isSafe(nextLine, pos + K, leftLine, rightLine)) {
                visited[nextLine][pos + K] = true;
                q.offer(new int[]{nextLine, pos + K, time + 1});
            }
        }

        System.out.println(0);
    }

    private static boolean isSafe(int line, int pos, String leftLine, String rightLine) {
        return (line == 0 ? leftLine.charAt(pos) : rightLine.charAt(pos)) == '1';
    }
}
