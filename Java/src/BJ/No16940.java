package BJ;
//그래프
//BFS 스페셜 저지

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No16940 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] a = new ArrayList[n];
        int[] parent = new int[n];
        int[] order = new int[n];
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            a[i] = new ArrayList<>();
        }

        //연관관계 삽입
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            a[u].add(v);
            a[v].add(u);
        }

        //순서 저장
        for (int i = 0; i < n; i++) {
            order[i] = sc.nextInt()-1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        check[0] = true;
        int m = 1;
        for (int i = 0; i < n; i++) {
            if (q.isEmpty()) {
                System.out.println(0);
                System.exit(0);
            }
            int x = q.remove();
            if (x != order[i]) { //순서가 다르면 틀림
                System.out.println(0);
                System.exit(0);
            }
            int cnt = 0; //정점과 연결된 수
            for (int y : a[x]) {
                if (check[y] == false) { //방문하지 않았으면
                    parent[y] = x; //앞에 x가 있어야함
                    cnt += 1;
                }
            }

            for (int j = 0; j < cnt; j++) {
                if (m + j >= n || parent[order[m + j]] != x) { //범위를 넘어서는 X, 앞에 x가 아니면
                    System.out.println(0);
                    System.exit(0);
                }
                q.add(order[m + j]);
                check[order[m + j]] = true;
            }
            m += cnt;
        }
        System.out.println(1);
    }
}
