package BJ;
// N으로 만들기

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class No17255 {

    static char[] a;
    static Set<String> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.next().toCharArray();
        set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            go(i, i, String.valueOf(a[i]), String.valueOf(a[i]));
        }
        System.out.println(set.size());
    }

    static void go(int left, int right, String s, String path) {
        if (left == 0 && right == a.length - 1) {
            set.add(path);
            return;
        }
        if (left - 1 >= 0) {
            String newStr = a[left - 1] + s;
            go(left - 1, right, newStr, path + " " + newStr);
        }
        if (right + 1 < a.length) {
            String newStr = s + a[right + 1];
            go(left, right + 1, newStr, path + " " + newStr);
        }
    }
}
