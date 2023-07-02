package Programmers;
// 삼각 달팽이

import java.util.Arrays;

public class PG68645 {

    public static void main(String[] args) {
        PG68645 pg68645 = new PG68645();
        System.out.println(Arrays.toString(pg68645.solution(4))); // [1,2,9,3,10,8,4,5,6,7]
    }

    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int[] result;
        int maxNum = (n * (n + 1)) / 2;
        result = new int[maxNum];

        // 달팽이 규칙 위치 변화
        int[] dr = {1, 0, -1};
        int[] dc = {0, 1, -1};

        int value = 1;
        int r = -1, c = 0;
        int d = 0;

        // 삼각형에 숫자 채우기
        while (value <= maxNum) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (0 <= nr && nr < n && 0 <= nc && nc < n && triangle[nr][nc] == 0) {
                triangle[nr][nc] = value++;
                r = nr;
                c = nc;
            } else {
                d = (d + 1) % 3;
            }
        }

        // 1차원 배열로 변환
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }
}
