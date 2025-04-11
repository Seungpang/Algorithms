package BJ;
// 색종이 붙이기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17136 {
    static int[][] paper = new int[10][10];
    static int[] colorPaper = {0, 5, 5, 5, 5, 5}; // 인덱스가 색종이 크기, 값이 남은 개수
    static int answer = Integer.MAX_VALUE;
    static int remainOnes = 0; // 남은 1의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                if (paper[i][j] == 1) remainOnes++;
            }
        }

        dfs(0, 0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void dfs2(int x, int y, int count) {
        if (x >= 9 && y > 9) {
            answer = Math.min(answer, count);
            return;
        }

        if (count >= answer) return;

        if (y > 9) {
            dfs(x + 1, 0, count);
            return;
        }

        if (paper[x][y] == 1) {
            for (int size = 5; size >= 1; size--) {
                if (colorPaper[size] > 0 && canAttach(x, y, size)) {
                    attach(x, y, size, 0);
                    colorPaper[size]--;
                    remainOnes -= size * size;

                    dfs(x, y + 1, count + 1);

                    attach(x, y, size, 1);
                    colorPaper[size]++;
                    remainOnes += size * size;
                }
            }
        } else {
            dfs(x, y + 1, count);
        }
    }

    static void dfs(int x, int y, int count) {
        if (x >= 9 && y > 9) {
            answer = Math.min(answer, count);
            return;
        }

        if (count >= answer) return; // 가지치기

        if (y > 9) {
            dfs(x + 1, 0, count);
            return;
        }

        if (paper[x][y] == 1) {
            for (int size = 5; size >= 1; size--) {
                if (colorPaper[size] > 0 && canAttach(x, y, size)) {
                    attach(x, y, size, 0); // 색종이 붙이기
                    colorPaper[size]--;
                    remainOnes -= size * size;

                    dfs(x, y + 1, count + 1);

                    attach(x, y, size, 1); // 색종이 떼기 (백트래킹)
                    colorPaper[size]++;
                    remainOnes += size * size;
                }
            }
        } else {
            dfs(x, y + 1, count);
        }
    }

    static boolean canAttach(int x, int y, int size) {
        if (x + size > 10 || y + size > 10) return false;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] == 0) return false;
            }
        }
        return true;
    }

    static void attach(int x, int y, int size, int state) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                paper[i][j] = state;
            }
        }
    }
}
