package BJ;

import java.util.ArrayList;
import java.util.Scanner;

public class No14889 {
    static int[][] s;
    static int n;
    public static int go(int index, ArrayList<Integer> first, ArrayList<Integer> second) {
        //정답인 경우
        if (index == n) {
            if (first.size() != n/2) return -1;
            if (second.size() != n/2) return -1;
            int team1 = 0;
            int team2 = 0;
            for (int i=0; i<n/2; i++)  {
                for (int j=0; j<n/2; j++) {
                    if (i==j) continue;
                    team1 += s[first.get(i)][first.get(j)];
                    team2 += s[second.get(i)][second.get(j)];
                }
            }
            int diff = Math.abs(team1 - team2);
            return diff;
        }
        //백트래킹 조건
        if (first.size() > n/2) return -1;
        if (second.size() > n/2) return -1;
        int ans = -1;
        //첫번째 팀에 넣는 경우
        first.add(index);
        int team1 = go(index + 1, first, second);
        if (ans == -1 || (team1 != -1 && ans >team1)) {
            ans = team1;
        }
        first.remove(first.size() - 1);
        //두번째 팀에 넣는 경우
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
        System.out.println(go(0, first, second));
    }
}
