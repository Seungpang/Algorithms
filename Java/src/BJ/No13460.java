package BJ;
// 구슬 탈출 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No13460 {

	static int N, M;
	static char[][] map;
	static boolean[][][][] visited;
	static int holeX, holeY;
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][N][M];

		int redX = 0;
		int redY = 0;
		int blueX = 0;
		int blueY = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'R') {
					redX = i;
					redY = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					blueX = i;
					blueY = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'O') {
					holeX = i;
					holeY = j;
				}
			}
		}

		int result = bfs(redX, redY, blueX, blueY);
		System.out.println(result);
	}

	static int bfs(int redX, int redY, int blueX, int blueY) {
		Queue<State> q = new LinkedList<>();
		q.offer(new State(redX, redY, blueX, blueY, 0));
		visited[redX][redY][blueX][blueY] = true;

		while (!q.isEmpty()) {
			State curr = q.poll();
			if (curr.count > 10) {
				return -1;
			}
			for (int[] dir : dirs) {
				int[] redRes = move(curr.redX, curr.redY, dir[0], dir[1]);
				int[] blueRes= move(curr.blueX, curr.blueY, dir[0], dir[1]);

				int nRedX = redRes[0];
				int nRedY = redRes[1];
				int redMoves = redRes[2];
				int nBlueX = blueRes[0];
				int nBlueY = blueRes[1];
				int blueMoves = blueRes[2];

				if (nBlueX == holeX && nBlueY == holeY) {
					continue;
				}
				if (nRedX == holeX && nRedY == holeY) {
					return curr.count + 1;
				}

				if (nRedX == nBlueX && nRedY == nBlueY) {
					if (redMoves > blueMoves) {
						nRedX -= dir[0];
						nRedY -= dir[1];
					} else {
						nBlueX -= dir[0];
						nBlueY -= dir[1];
					}
				}

				if (!visited[nRedX][nRedY][nBlueX][nBlueY]) {
					visited[nRedX][nRedY][nBlueX][nBlueY] = true;
					q.offer(new State(nRedX, nRedY, nBlueX, nBlueY, curr.count + 1));
				}
			}
		}
		return -1;
	}

	static int[] move(int x, int y, int dx, int dy) {
		int moves = 0;
		while (true) {
			if (map[x + dx][y + dy] == '#') break;
			x += dx;
			y += dy;
			moves++;
			if (map[x][y] == 'O') break;
		}
		return new int[]{x, y, moves};
	}

	static class State {
		int redX, redY, blueX, blueY, count;

		public State(final int redX, final int redY, final int blueX, final int blueY, final int count) {
			this.redX = redX;
			this.redY = redY;
			this.blueX = blueX;
			this.blueY = blueY;
			this.count = count;
		}
	}
}
