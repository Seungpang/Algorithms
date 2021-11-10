package BJ2;
//순열
//부등호

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class No2529 {

    static int n;
    static ArrayList<String> ans = new ArrayList<>();
    static boolean[] check = new boolean[10];
    static char[] c;

    static boolean checkNum(char x, char y, char op) {
        if (op == '<') {
            if (x > y) return false;
        }
        if (op == '>') {
            if (x < y) return false;
        }
        return true;
    }

    static void dfs(int index, String num) {
        if (index == n + 1) {
            ans.add(num);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (check[i]) continue;
            if (index == 0 || checkNum(num.charAt(index - 1), (char) (i + '0'), c[index - 1])) {
                check[i] = true;
                dfs(index + 1, num + Integer.toString(i));
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = new char[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.next().toCharArray()[0];
        }
        int index = 0;
        dfs(0, "");
        Collections.sort(ans);

        int m = ans.size();
        System.out.println(ans.get(m - 1));
        System.out.println(ans.get(0));
    }
}
