package BJ;
// 트리

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No1068 {

    static int answer;
    static int root;
    static int del;
    static List<Integer>[] child = new ArrayList[55];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < 55; i++) {
            child[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            if (p == -1) {
                root = i;
                continue;
            }
            child[p].add(i);
        }
        del = sc.nextInt();
        System.out.println(go(root));
    }

    static int go(int x) {
        if (x == del) {
            return 0;
        }
        if (child[x].isEmpty()) {
            return 1;
        }
        if (child[x].size() == 1 && child[x].get(0) == del) {
            return 1;
        }

        int result = 0;
        for (int next : child[x]) {
            result += go(next);
        }
        return result;
    }
}
