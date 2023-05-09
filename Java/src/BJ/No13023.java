package BJ;
//그래프
//ABCDE

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No13023 {

    static int n, m;
    static List<Integer>[] arr;
    static boolean[] visited;
    static boolean isFlag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new ArrayList[n];
        visited = new boolean[n];
        isFlag = false;

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr[start].add(end);
            arr[end].add(start);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, 1);
            if (isFlag) {
                break;
            }
        }

        if (isFlag) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    static void dfs(int now, int depth) {
        if (depth == 5 || isFlag) {
            isFlag = true;
            return;
        }
        visited[now] = true;
        for (int i : arr[now]) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }
        visited[now] = false;
    }
}
