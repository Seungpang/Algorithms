package BJ;
// 창업

import java.util.Arrays;
import java.util.Scanner;

public class No16890 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.nextLine().toCharArray();
        char[] t = sc.nextLine().toCharArray();
        int n = s.length;

        Arrays.sort(s);
        Arrays.sort(t);
        for (int i = 0; i < n / 2; i++) {
            char temp = t[i];
            t[i] = t[n - 1 - i];
            t[n - 1 - i] = temp;
        }

        int aLen = (n + 1) / 2;
        int bLen = n / 2;
        char[] a = Arrays.copyOfRange(s, 0, aLen);
        char[] b = Arrays.copyOfRange(t, 0, bLen);

        int aLeft = 0, aRight = aLen - 1;
        int bLeft = 0, bRight = bLen - 1;
        int left = 0, right = n - 1;
        char[] ans = new char[n];

        for (int turn = 0; turn < n; turn++) {
            if (turn % 2 == 0) {
                if (bLeft <= bRight && a[aLeft] >= b[bLeft]) {
                    ans[right--] = a[aRight--];
                } else {
                    ans[left++] = a[aLeft++];
                }
            } else {
                if (aLeft <= aRight && b[bLeft] <= a[aLeft]) {
                    ans[right--] = b[bRight--];
                } else {
                    ans[left++] = b[bLeft++];
                }
            }
        }
        System.out.println(new String(ans));
    }
}
