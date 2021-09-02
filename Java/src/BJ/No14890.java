package BJ;
//시뮬레이션 구현
//경사로

import java.util.Scanner;

public class No14890 {
    static boolean go(int[] a, int l) {
        int n = a.length;
        boolean[] check = new boolean[n];
        for (int i=1; i<n; i++) {
            if (a[i] != a[i-1]) {
                //인접한 칸의 높이가 다르면 경사로 놓아야 함
                int diff = a[i] - a[i - 1];
                if (diff < 0) diff = -diff;
                // 낮은 칸과 높은 칸의 차이는 1이어야 함
                if (diff != 1) {
                    return false;
                }
                if (a[i-1] < a[i]) {
                    for (int j=1; j<=l; j++) {
                        //경사로 범위 벗어남
                        if (i-j < 0) {
                            return false;
                        }
                        //낮은 칸의 높이가 같지 않거나 L개가 연속되지 않을 경우
                        if (a[i-1] != a[i-j]) {
                            return false;
                        }
                        //경사로를 놓은 곳에 또 놓는 경우
                        if (check[i-j]) {
                            return false;
                        }
                        check[i - j] = true;
                    }
                } else {
                    for (int j=0; j<l; j++) {
                        //경사로 범위 벗어남
                        if (i+j >= n) {
                            return false;
                        }
                        //낮은 칸의 높이가 같지 않거나 L개가 연속되지 않을 경우
                        if (a[i] != a[i+j]) {
                            return false;
                        }
                        //경사로를 놓은 곳에 또 놓는 경우
                        if (check[i + j]) {
                            return false;
                        }
                        check[i + j] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int result = 0;
        for (int i=0; i<n; i++) {
            int[] d = new int[n];
            for (int j=0; j<n; j++) {
                d[j] = a[i][j];
            }
            if (go(d,l)) result += 1;
        }

        for (int j=0; j<n; j++) {
            int[] d = new int[n];
            for (int i=0; i<n; i++) {
                d[i] = a[i][j];
            }
            if (go(d,l)) result +=1;
        }
        System.out.println(result);
    }
}
