package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2615 {

    static int[][] map;
    static int[][] dirs = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[19][19];
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] != 0) {
                    for (int[] dir : dirs) {
                        int count = 1;
                        int nx = i + dir[0];
                        int ny =j + dir[1];

                        while (nx >= 0 && nx <19 && ny >=0 && ny < 19 && map[nx][ny] == map[i][j]) {
                            count++;
                            nx += dir[0];
                            ny += dir[1];
                        }

                        if (count == 5) {
                            if (i - dir[0] >= 0 && i - dir[0] < 19 && j - dir[1] >= 0 && j - dir[1] < 19 &&
                                    map[i-dir[0]][j-dir[1]] == map[i][j] || (nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && map[nx][ny] == map[i][j])) {
                                continue;
                            }

                            System.out.println(map[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}
