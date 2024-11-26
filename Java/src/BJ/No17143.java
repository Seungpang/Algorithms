package BJ;
// 낚시왕

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17143 {

    static int R, C, M;
    static Shark[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R + 1][C + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = new Shark(r, c, s, d, z);
        }

        long answer = 0;

        for (int c = 1; c <= C; c++) {
            for (int r = 1; r <= R; r++) {
                if (map[r][c] != null) {
                    answer += map[r][c].z;
                    map[r][c] = null;
                    break;
                }
            }

            moveSharks();
        }

        System.out.println(answer);
    }

    static void moveSharks() {
        Shark[][] newMap = new Shark[R + 1][C + 1];

        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (map[r][c] == null) continue;

                final Shark shark = map[r][c];

                int s = shark.s;
                if (shark.d == 1 || shark.d == 2) {
                    s %= (2 * (R - 1));
                } else {
                    s %= (2 * (C - 1));
                }

                int nr = r;
                int nc = c;
                int d = shark.d;

                for (int i = 0; i < s; i++) {
                    if (d == 1) {
                        nr--;
                        if (nr < 1) {
                            nr = 2;
                            d = 2;
                        }
                    } else if (d == 2) {
                        nr++;
                        if (nr > R) {
                            nr = R - 1;
                            d = 1;
                        }
                    } else if (d == 3) {
                        nc++;
                        if (nc > C) {
                            nc = C - 1;
                            d = 4;
                        }
                    } else if (d == 4) {
                        nc--;
                        if (nc < 1) {
                            nc = 2;
                            d = 3;
                        }
                    }
                }

                Shark movedShark = new Shark(nr, nc, shark.s, d, shark.z);
                if (newMap[nr][nc] == null) {
                    newMap[nr][nc] = movedShark;
                } else {
                    if (newMap[nr][nc].z < movedShark.z) {
                        newMap[nr][nc] = movedShark;
                    }
                }
            }
        }

        map = newMap;
    }

    static class Shark {
        int r, c, s, d, z;

        public Shark(final int r, final int c, final int s, final int d, final int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
