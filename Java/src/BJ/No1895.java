package BJ;
// 필터

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1895 {

    static int R, C;
    static int[][] images;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        images = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                images[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<R-2; i++) {
            for (int j = 0; j < C-2; j++) {
                if (findMiddleValue(i, j) >= T) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static int findMiddleValue(int x, int y) {
        int[] arr = new int[9];
        int index = 0;
        for (int i = x; i <= x + 2; i++) {
            for (int j = y; j <= y + 2; j++) {
                arr[index++] = images[i][j];
            }
        }

        Arrays.sort(arr);

        return arr[4];
    }
}
