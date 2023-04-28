package BJ;
// 전공책

import java.util.Scanner;

public class No16508 {
    static int[] alphaCount = new int[26];
    static int[] selectCount = new int[26];
    static int result = Integer.MAX_VALUE, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t.length(); i++) {
            alphaCount[t.charAt(i) - 'A']++;
        }
        String[][] book = new String[n][2];
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            book[i] = str.split(" ");
        }

        dfs(0, 0, book);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static void dfs(int index, int totalPrice, String[][] book) {
        if (index == n) {
            if (isPossible()) {
                result = Math.min(result, totalPrice);
            }
            return;
        }

        for (int i = 0; i < book[index][1].length(); i++) {
            selectCount[book[index][1].charAt(i) - 'A']++;
        }

        dfs(index + 1, totalPrice + Integer.parseInt(book[index][0]), book);

        for (int i = 0; i < book[index][1].length(); i++) {
            selectCount[book[index][1].charAt(i) - 'A']--;
        }

        dfs(index + 1, totalPrice, book);
    }

    public static boolean isPossible() {
        for (int i = 0; i < 26; i++) {
            if (alphaCount[i] > selectCount[i]) {
                return false;
            }
        }
        return true;
    }
}
