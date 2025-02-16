package BJ;
// ZOAC

import java.util.Scanner;

public class No16719 {

    static String word;
    static boolean[] selected;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        word = sc.nextLine();
        n = word.length();
        selected = new boolean[n];
        dfs();
    }

    static void dfs() {
        String curr = buildCurrentString();
        if (!curr.isEmpty()) {
            System.out.println(curr);
        }
        if (curr.length() == n) {
            return;
        }

        String best = null;
        int bestIndex = -1;
        for (int i = 0; i < n; i++) {
            if (!selected[i]) {
                selected[i] = true;
                String candidate = buildCurrentString();
                if (best == null || candidate.compareTo(best) < 0) {
                    best = candidate;
                    bestIndex = i;
                }
                selected[i] = false;
            }
        }

        if (bestIndex != -1) {
            selected[bestIndex] = true;
            dfs();
        }
    }

    static String buildCurrentString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (selected[i]) {
                sb.append(word.charAt(i));
            }
        }
        return sb.toString();
    }
}
