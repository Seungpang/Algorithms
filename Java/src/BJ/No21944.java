package BJ;
// 문제 추천 시스템 Version 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class No21944 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        TreeSet<Problem> global = new TreeSet<>();
        Map<Integer, TreeSet<Problem>> groups = new HashMap<>();
        Map<Integer, Problem> problems = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            Problem p = new Problem(id, l, g);
            problems.put(id, p);
            global.add(p);
            groups.putIfAbsent(g, new TreeSet<>());
            groups.get(g).add(p);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("add")) {
                int id = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                Problem p = new Problem(id, l, g);
                problems.put(id, p);
                global.add(p);
                groups.putIfAbsent(g, new TreeSet<>());
                groups.get(g).add(p);
            } else if (command.equals("solved")) {
                int id = Integer.parseInt(st.nextToken());
                Problem p = problems.get(id);
                global.remove(p);
                groups.get(p.g).remove(p);
                problems.remove(id);
            } else if (command.equals("recommend")) {
                int g = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                TreeSet<Problem> set = groups.get(g);
                if (x == 1) {
                    sb.append(set.last().id).append("\n");
                } else {
                    sb.append(set.first().id).append("\n");
                }
            } else if (command.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) {
                    sb.append(global.last().id).append("\n");
                } else {
                    sb.append(global.first().id).append("\n");
                }
            } else if(command.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                if(x == 1) {
                    Problem dummy = new Problem(0, L, 0);
                    Problem ans = global.ceiling(dummy);
                    if(ans == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(ans.id).append("\n");
                    }
                } else {
                    Problem dummy = new Problem(0, L, 0);
                    Problem ans = global.lower(dummy);
                    if(ans == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(ans.id).append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }

    static class Problem implements Comparable<Problem> {
        int id;
        int l;
        int g;

        public Problem(final int id, final int l, final int g) {
            this.id = id;
            this.l = l;
            this.g = g;
        }

        @Override
        public int compareTo(final Problem o) {
            if (this.l != o.l) {
                return this.l - o.l;
            }
            return this.id - o.id;
        }
    }
}
