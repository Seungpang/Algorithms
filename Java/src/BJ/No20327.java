package BJ;
//시뮬레이션 구현
//배열 돌리기 6

import java.util.Scanner;

public class No20327 {

    static int[][] op1(int[][] a) {
        int n = a.length;
        int[][] ans = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                ans[i][j] = a[n - 1 - i][j];
            }
        }
        return ans;
    }

    static int[][] op2(int[][] a) {
        int n = a.length;
        int[][] ans = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                ans[i][j] = a[i][n-1-j];
            }
        }
        return ans;
    }

    static int[][] op3(int[][] a) {
        int n = a.length;
        int[][] ans = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = a[n - j - 1][i];
            }
        }
        return ans;
    }

    static int[][] op4(int[][] a) {
        int n = a.length;
        int[][] ans = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = a[j][n - i - 1];
            }
        }
        return ans;
    }

    static int[][] op5(int[][] a, int l) {
        int n = a.length;
        int[][] ans = new int[n][n];
        int sub_size = (1 << l);
        int sub_count = n / sub_size;
        for (int i=0; i<sub_count; i++) {
            for (int j=0; j <sub_count; j++) {
                int x1 = i * sub_size;
                int y1 = j * sub_size;
                int x2 = (sub_count - i - 1) * sub_size;
                int y2 = j * sub_size;
                for (int x=0; x<sub_size; x++) {
                    for (int y=0; y<sub_size; y++) {
                        ans[x1 + x][y1 + y] = a[x2 + x][y2 + y];
                    }
                }
            }
        }
        return ans;
    }

    static int[][] op6(int[][] a, int l) {
        int n = a.length;
        int[][] ans = new int[n][n];
        int sub_size = (1 << l);
        int sub_count = n / sub_size;
        for (int i=0; i<sub_count; i++) {
            for (int j=0; j <sub_count; j++) {
                int x1 = i * sub_size;
                int y1 = j * sub_size;
                int x2 = i * sub_size;
                int y2 = (sub_count - j - 1) * sub_size;
                for (int x=0; x<sub_size; x++) {
                    for (int y=0; y<sub_size; y++) {
                        ans[x1 + x][y1 + y] = a[x2 + x][y2 + y];
                    }
                }
            }
        }
        return ans;
    }

    static int[][] op7(int[][] a, int l) {
        int n = a.length;
        int[][] ans = new int[n][n];
        int sub_size = (1 << l);
        int sub_count = n / sub_size;
        for (int i=0; i<sub_count; i++) {
            for (int j=0; j <sub_count; j++) {
                int x1 = i * sub_size;
                int y1 = j * sub_size;
                int x2 = (sub_count - j - 1) * sub_size;
                int y2 = i * sub_size;
                for (int x=0; x<sub_size; x++) {
                    for (int y=0; y<sub_size; y++) {
                        ans[x1 + x][y1 + y] = a[x2 + x][y2 + y];
                    }
                }
            }
        }
        return ans;
    }

    static int[][] op8(int[][] a, int l) {
        int n = a.length;
        int[][] ans = new int[n][n];
        int sub_size = (1 << l);
        int sub_count = n / sub_size;
        for (int i=0; i<sub_count; i++) {
            for (int j=0; j <sub_count; j++) {
                int x1 = i * sub_size;
                int y1 = j * sub_size;
                int x2 = j * sub_size;
                int y2 = (sub_count - i - 1) * sub_size;
                for (int x=0; x<sub_size; x++) {
                    for (int y=0; y<sub_size; y++) {
                        ans[x1 + x][y1 + y] = a[x2 + x][y2 + y];
                    }
                }
            }
        }
        return ans;
    }

    static void op_1_to_4(int[][] a, int k, int sx, int sy, int len) {
        int[][] b = new int[len][len];
        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                b[i][j] = a[sx + i][sy + j];
            }
        }
        if (k==1) {
            b = op1(b);
        } else if (k==2) {
            b = op2(b);
        } else if (k==3) {
            b = op3(b);
        } else if (k==4) {
            b = op4(b);
        }
        for (int i = 0; i<len; i++) {
            for (int j=0; j<len; j++) {
                a[sx + i][sy + j] = b[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int size = (1 << n);
        int[][] a = new int[size][size];
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        while (r-- > 0) {
            int k = sc.nextInt();
            int l = sc.nextInt();
            int sub_size = (1 << l);
            if (1 <= k && k <= 4) {
                for (int i = 0; i < size; i += sub_size) {
                    for (int j = 0; j < size; j += sub_size) {
                        op_1_to_4(a,k,i,j,sub_size);
                    }
                }
            } else if (5 <= k && k <=8) {
                if (k==5) {
                    a = op5(a, l);
                } else if (k==6) {
                    a = op6(a, l);
                } else if (k==7) {
                    a = op7(a, l);
                } else if (k == 8) {
                    a = op8(a, l);
                }
            }
        }
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
