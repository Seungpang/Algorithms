package BJ;
//그래프
//ABCDE

import java.util.ArrayList;
import java.util.Scanner;

public class No13023 {

    static int n,m;
    static ArrayList<Integer>[] g;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        g = (ArrayList<Integer>[]) new ArrayList[n];

        for (int i=0; i<n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            g[from].add(to);
            g[to].add(from);
        }

        for (int i=0; i<n; i++) {
            visited = new boolean[n];
            dfs(i, 0);
        }
        System.out.println(0);
    }

    public static void dfs(int x, int len) {
        if(len == 4) {
            System.out.println(1);
            System.exit(0);
        }

        visited[x] = true;
        for (int i=0; i< g[x].size(); i++) {
            int temp = g[x].get(i);
            if (visited[temp] == false) {
                visited[temp] = true;
                dfs(temp, len + 1);
                visited[temp] = false;
            }
        }
    }
}
