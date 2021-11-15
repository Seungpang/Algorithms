package BJ;
//자료 구조
//검열

import java.util.Scanner;

public class No3111 {

    static char[] left = new char[300001];
    static char[] right = new char[300001];
    static int ln = 0;
    static int rn = 0;
    static char[] a;
    static char[] ar;
    static char[] b;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextLine().toCharArray();
        n = a.length;
        ar = new char[n];
        for (int i = 0; i < n; i++) {
            ar[i] = a[n - i - 1];
        }
        b = sc.nextLine().toCharArray();
        m = b.length;
        int l = 0;
        int r = m - 1;
        int where = 0;
        while (l <= r) {
            if (where == 0) {
                left[ln++] = b[l++]; //왼쪽에서부터 하나씩 확인
            } else {
                right[rn++] = b[r--]; //오른쪽에서부터 하나씩 확인
            }
            if (check(where)) {
                where = 1 - where;
            }
        }

        for (int i = ln - 1; i >= 0; i--) {
            right[rn++] = left[i]; //오른쪽 왼쪽 합치는 작업
            check(1); //오른쪽으로 마지막으로 합쳤기 때문에
        }

        for (int i = rn - 1; i >= 0; i--) {
            System.out.print(right[i]);
        }
        System.out.println();
    }

    private static boolean check(int where) {
        char[] stack = left;
        int len = ln;
        char[] str = ar;

        if (where == 1) {
            stack = right;
            len = rn;
            str = a;
        }

        if (len - n < 0) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (stack[len - i - 1] != str[i]) {
                return false;
            }
        }

        if (where == 0) {
            ln -= n;
        } else {
            rn -= n;
        }
        return true;
    }
}
