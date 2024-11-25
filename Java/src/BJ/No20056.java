package BJ;
// 마법사 상어와 파이어볼

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class No20056 {

    static int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Fireball> fireballs = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(r - 1, c - 1, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            fireballs = moveFireballs(fireballs, N);
            fireballs = mergeAndSplit(fireballs);
        }

        long answer = 0;
        for (Fireball fireball : fireballs) {
            answer += fireball.m;
        }

        System.out.println(answer);
    }

    static List<Fireball> moveFireballs(List<Fireball> fireballs, int N) {
        List<Fireball> moved = new ArrayList<>();

        for (Fireball fireball : fireballs) {
            int nr = fireball.r + dirs[fireball.d][0] * fireball.s;
            int nc = fireball.c + dirs[fireball.d][1] * fireball.s;

            nr = (nr % N + N) % N;
            nc = (nc % N + N) % N;

            moved.add(new Fireball(nr, nc, fireball.m, fireball.s, fireball.d));
        }

        return moved;
    }

    static List<Fireball> mergeAndSplit(List<Fireball> fireballs) {
        Map<String, List<Fireball>> map = new HashMap<>();

        for (Fireball fireball : fireballs) {
            String key = fireball.r + "," + fireball.c;
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(fireball);
        }

        List<Fireball> newFireballs = new ArrayList<>();
        for (String key : map.keySet()) {
            List<Fireball> list = map.get(key);

            if (list.size() == 1) {
                newFireballs.add(list.get(0));
            } else {
                int sumM = 0;
                int sumS = 0;
                boolean allEven = true;
                boolean allOdd = true;

                for (Fireball fireball : list) {
                    sumM += fireball.m;
                    sumS += fireball.s;
                    if (fireball.d % 2 == 0) {
                        allOdd = false;
                    } else {
                        allEven = false;
                    }
                }

                int count = list.size();
                int newM = sumM / 5;
                int newS = sumS / count;

                if (newM == 0) {
                    continue;
                }

                int[] directions;
                if (allEven || allOdd) {
                    directions = new int[]{0, 2, 4, 6};
                } else {
                    directions = new int[]{1, 3, 5, 7};
                }

                String[] rc = key.split(",");
                int r = Integer.parseInt(rc[0]);
                int c = Integer.parseInt(rc[1]);
                for (int d : directions) {
                    newFireballs.add(new Fireball(r, c, newM, newS, d));
                }
            }
        }

        return newFireballs;
    }

    static class Fireball {
        int r, c, m, s, d;

        public Fireball(final int r, final int c, final int m, final int s, final int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
