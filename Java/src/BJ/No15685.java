package BJ;
//시뮬레이션 구현
//드래곤 커브

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class No15685 {

    static boolean[][] check = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<Integer> curve(int dir, int gen) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(dir); //0세대 만들어주기
        for (int g=1; g<=gen; g++) {
            ArrayList<Integer> temp = new ArrayList<>(ans);
            Collections.reverse(temp);
            for (int i=0; i<temp.size(); i++) {
                temp.set(i, (temp.get(i) + 1) % 4);
            }
            System.out.println("temp = " + temp);
            ans.addAll(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int dir = sc.nextInt();
            int gen = sc.nextInt();
            ArrayList<Integer> dirs = curve(dir, gen);
            check[x][y] = true;
            for (int d : dirs) {
                x += dx[d];
                y += dy[d];
                check[x][y] = true;
            }
        }
        int result = 0;
        for (int i=0; i<=99; i++) {
            for (int j=0; j<=99; j++) {
                if (check[i][j] && check[i][j + 1] && check[i + 1][j] && check[i + 1][j + 1]) {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}
