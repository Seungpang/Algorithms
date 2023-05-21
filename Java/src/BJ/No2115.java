package BJ;
// 갤러리

import java.util.Scanner;

public class No2115 {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] map = new char[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        boolean[][][] visited = new boolean[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '.') {
                    stickitWall(i, j, map, visited);
                }
            }
        }
        System.out.println(answer);
    }

    static void stickitWall(int i, int j, char[][] map, boolean[][][] visited) {
        int r = i;
        int c = j;
        for (int k = 0; k < 4; k++) {
            int nr = r + dirs[k][0];
            int nc = c + dirs[k][1];
            if (visited[nr][nc][k]) {
                continue;
            }
            if (map[nr][nc] == '.') {
                if (k < 2) {
                    for (int l = 2; l < 4; l++) {
                        if (map[r + dirs[l][0]][c + dirs[l][1]] == 'X' && map[nr + dirs[l][0]][nc + dirs[l][1]] == 'X') {
                            if (visited[r + dirs[l][0]][c + dirs[l][1]][l] || visited[nr + dirs[l][0]][nc + dirs[l][1]][l]) {
                                continue;
                            }
                            answer++;
                            visited[r + dirs[l][0]][c + dirs[l][1]][l] = true;
                            visited[nr + dirs[l][0]][nc + dirs[l][1]][l] = true;
                        }
                    }
                } else {
                    for (int l = 0; l < 2; l++) {
                        if (map[r + dirs[l][0]][c + dirs[l][1]] == 'X' && map[nr + dirs[l][0]][nc + dirs[l][1]] == 'X') {
                            if (visited[r + dirs[l][0]][c + dirs[l][1]][l] || visited[nr + dirs[l][0]][nc + dirs[l][1]][l]) {
                                continue;
                            }
                            answer++;
                            visited[r + dirs[l][0]][c + dirs[l][1]][l] = true;
                            visited[nr + dirs[l][0]][nc + dirs[l][1]][l] = true;
                        }
                    }
                }
            }
        }
    }
}