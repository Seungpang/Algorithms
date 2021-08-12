package BJ;

import java.util.Scanner;

public class No15652 {

    static int[] a = new int[10];
    static StringBuilder sb = new StringBuilder();

    static StringBuilder go(int index, int start, int n, int m) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<m; i++) {
                sb.append(a[i]);
                if (i != m-1) sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder ans = new StringBuilder();
        for (int i=start; i<=n; i++) {
            a[index] = i;
            ans.append(go(index + 1, i, n, m));
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.print(go(0,1,n,m));
    }
}
