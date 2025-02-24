package BJ;
// 미친 아두이노

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No8972 {

    static int R, C;
    static char[][] map;
    static int[][] dirs = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 0}, {0, 1},{-1, -1}, {-1, 0}, {-1, 1}};
    static int[][] visitCount;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        map = new char[R][C];

        int[] jongsu = new int[2];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    q.offer(new int[]{i, j});
                } else if (map[i][j] == 'I') {
                    jongsu[0] = i;
                    jongsu[1] = j;
                }
            }
        }

        String s = sc.nextLine();
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - '0' - 1;
        }

        for (int i = 0; i < n; i++) {
            visitCount = new int[R][C];
            map[jongsu[0]][jongsu[1]] = '.';
            int nx = jongsu[0] + dirs[nums[i]][0];
            int ny = jongsu[1] + dirs[nums[i]][1];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (map[nx][ny] == 'R') {
                    System.out.println("kraj " + (i + 1));
                    return;
                }
                map[nx][ny] = 'I';
                jongsu[0] = nx;
                jongsu[1] = ny;
            }

            int size = q.size();
            for (int j = 0; j < size; j++) {
                int[] now = q.poll();
                int min = Integer.MAX_VALUE;;
                int x = now[0];
                int y = now[1];
                map[x][y] = '.';
                for (int[] dir : dirs) {
                    int nr = dir[0] + now[0];
                    int nc = dir[1] + now[1];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    int dist = Math.abs(jongsu[0] - nr) + Math.abs(jongsu[1] - nc);
                    if (dist < min) {
                        min = dist;
                        x = nr;
                        y = nc;
                    }
                }
                if (map[x][y] == 'I') {
                    System.out.println("kraj " + (i + 1));
                    return;
                }

                visitCount[x][y]++;
                q.offer(new int[]{x, y});
            }

            for (int j = 0; j < size; j++) {
                int[] pos = q.poll();
                if (visitCount[pos[0]][pos[1]] > 0) {
                    if (visitCount[pos[0]][pos[1]] == 1) {
                        map[pos[0]][pos[1]] = 'R';
                        q.offer(pos);
                    } else {
                        map[pos[0]][pos[1]] = '.';
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
