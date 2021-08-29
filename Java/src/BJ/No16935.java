package BJ;
//시뮬레이션과 구현
//배열돌리기 3

import java.util.Scanner;

public class No16935 {
    public static int[][] op1(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                result[i][j] = a[n - 1 - i][j];
            }
        }
        return result;
    }

    public static int[][] op2(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = a[i][m - 1 - j];
            }
        }
        return result;
    }

    public static int[][] op3(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = a[n - 1 - j][i];
            }
        }
        return result;
    }

    public static int[][] op4(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = a[j][m - 1 - i];
            }
        }
        return result;
    }

    public static int[][] op5(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m];
        for (int i=0; i<n/2; i++) {
            for (int j = 0; j < m/2; j++) {
                result[i][j + m / 2] = a[i][j];
                result[i + n / 2][j + m / 2] = a[i][j + m / 2];
                result[i + n / 2][j] = a[i + n / 2][j + m / 2];
                result[i][j] = a[i + n / 2][j];
            }
        }
        return result;
    }

    public static int[][] op6(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m];
        for (int i=0; i<n/2; i++) {
            for (int j = 0; j < m/2; j++) {
                result[i + n / 2][j] = a[i][j];
                result[i + n / 2][j + m / 2] = a[i + n / 2][j];
                result[i][j + m / 2] = a[i + n / 2][j + m / 2];
                result[i][j] = a[i][j + m / 2];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        while (t-- > 0) {
            int op = sc.nextInt();

            if (op==1) {
                a = op1(a);
            } else if (op==2) {
                a = op2(a);
            } else if (op==3) {
                a = op3(a);
            } else if (op==4) {
                a = op4(a);
            } else if (op==5) {
                a = op5(a);
            } else if (op==6) {
                a = op6(a);
            }
        }
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
