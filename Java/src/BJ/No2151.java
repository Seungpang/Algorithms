package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class No2151 {

    static int N;
    static char[][] map;
    static int startX, startY, endX, endY;
    static int[][][] dist;
    static int[] dx = {-1, 0, 1, 0}; // 상우하좌
    static int[] dy = {0, 1, 0, -1};
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        dist = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }
        int doorCount = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '#') {
                    if (doorCount == 0) {
                        startX = i;
                        startY = j;
                        doorCount++;
                    } else {
                        endX = i;
                        endY = j;
                    }
                }
            }
        }

        dijkstra();

        int minCost = INF;
        for (int d = 0; d < 4; d++) {
            if (dist[endX][endY][d] < minCost) {
                minCost = dist[endX][endY][d];
            }
        }
        System.out.println(minCost);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int d = 0; d < 4; d++) {
            dist[startX][startY][d] = 0;
            pq.offer(new Node(startX, startY, d, 0));
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int x = node.x;
            int y = node.y;
            int dir = node.dir;
            int cost = node.cost;

            if (x == endX && y == endY) continue;
            if (dist[x][y][dir] < cost) continue;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (map[nx][ny] == '*') continue;

            if (dist[nx][ny][dir] > cost) {
                dist[nx][ny][dir] = cost;
                pq.offer(new Node(nx, ny, dir, cost));
            }

            if (map[nx][ny] == '!') {
                // 방향 전환
                for (int k = -1; k <= 1; k += 2) {
                    int ndir = (dir + k + 4) % 4;
                    if (dist[nx][ny][ndir] > cost + 1) {
                        dist[nx][ny][ndir] = cost + 1;
                        pq.offer(new Node(nx, ny, ndir, cost + 1));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x, y, dir, cost;
        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}


/**
 * 풀이 과정
 *
 * 초기화:
 *
 * dist 배열을 정확히 초기화하여 각 위치와 방향에 대한 거울 설치 횟수를 저장할 수 있게 했습니다.
 * 시작 위치에서 모든 방향에 대해 거울 설치 횟수를 0으로 설정하고 우선순위 큐에 추가했습니다.
 * 다익스트라 알고리즘 수행:
 *
 * 우선순위 큐에서 현재 위치와 방향, 거울 설치 횟수를 가져옵니다.
 * 이미 더 작은 거울 설치 횟수로 방문한 위치와 방향이라면 스킵합니다.
 * 현재 방향으로 한 칸 이동합니다.
 * 이동한 위치가 범위를 벗어나거나 벽('*')이면 스킵합니다.
 * 이동한 위치에서의 거울 설치 횟수를 갱신하고, 우선순위 큐에 추가합니다.
 * 이동한 위치가 거울 설치 가능 위치('!')라면:
 * 현재 진행 방향에서 좌우로 90도 회전한 두 방향으로 거울을 설치하여 방향을 바꿉니다.
 * 거울 설치 횟수를 1 증가시키고, 새로운 방향과 함께 우선순위 큐에 추가합니다.
 * 결과 출력:
 *
 * 도착 지점에서의 최소 거울 설치 횟수를 찾아 출력합니다.
 */
