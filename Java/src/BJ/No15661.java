package BJ;

import java.util.ArrayList;
import java.util.Scanner;

public class No15661 {
    static int n;
    static int[][] s;

    public static int go(int index, ArrayList<Integer> first, ArrayList<Integer> second) {
        if (index == n) {
            if (first.size() == 0) return -1;
            if (second.size() == 0) return -1;
            int team1 = 0;
            int team2 = 0;
            for (int i=0; i<first.size(); i++) {
                for (int j=0; j<first.size(); j++) {
                    if (i==j) continue;
                    team1 += s[first.get(i)][first.get(j)];
                }
            }
            for (int i=0; i<second.size(); i++) {
                for (int j=0; j<second.size(); j++) {
                    if (i==j) continue;
                    team2 += s[second.get(i)][second.get(j)];
                }
            }
            int diff = Math.abs(team1 - team2);
            return diff;
        }
        int ans = -1;
        first.add(index);
        int team1 = go(index + 1, first, second);
        if (ans == -1 || (team1 != -1 && ans > team1)) {
            ans = team1;
        }
        first.remove(first.size() - 1);
        second.add(index);
        int team2 = go(index + 1, first, second);
        if (ans == -1 || (team2 != -1 && ans > team2)) {
            ans = team2;
        }
        second.remove(second.size() - 1);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                s[i][j] = sc.nextInt();
            }
        }
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        System.out.println(go(0,first,second));
    }
}
