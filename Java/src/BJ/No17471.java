package BJ;
// 게리맨더링

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17471 {

    static int N, min = Integer.MAX_VALUE;
    static int[] population; // 각 구역의 인구수
    static boolean[] selected; // A선거구인지 B선거구인지 나타내는 배열
    static List<Integer>[] adjList; // 인접 리스트

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        population = new int[N + 1];
        selected = new boolean[N + 1];
        adjList = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int countOfAdjacentArea = Integer.parseInt(st.nextToken());

            for (int j = 0; j < countOfAdjacentArea; j++) {
                int adjacentArea = Integer.parseInt(st.nextToken());
                adjList[i].add(adjacentArea);
            }
        }

        divideIntoTwo(1);
        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    public static void divideIntoTwo(int index) {
        if (index == N + 1) {
            bfs();
            return;
        }

        selected[index] = true;
        divideIntoTwo(index + 1);

        selected[index] = false;
        divideIntoTwo(index + 1);
    }

    public static void bfs() {
        int[] sum = new int[2]; // 각 선거구의 인구 합을 저장할 배열
        boolean[] visited = new boolean[N + 1]; // 방문 여부를 저장할 배열

        for (int k = 0; k < 2; k++) { // 0: A선거구, 1: B선거구
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= N; i++) {
                if (selected[i] == (k == 0) && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    break;
                }
            }

            while (!queue.isEmpty()) {
                int currentArea = queue.poll();
                sum[k] += population[currentArea];

                for (int nextArea : adjList[currentArea]) {
                    if (selected[nextArea] == (k == 0) && !visited[nextArea]) {
                        queue.add(nextArea);
                        visited[nextArea] = true;
                    }
                }
            }
        }

        // 두 선거구 모두 방문했는지 확인
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) return;
        }

        min = Math.min(min, Math.abs(sum[0] - sum[1]));
    }
}
