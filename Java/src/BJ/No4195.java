package BJ;
// 친구 네트워크

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No4195 {

    static Map<String, Integer> ids;
    static int[] parent, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());
            ids = new HashMap<>();
            parent = new int[2 * F];
            size = new int[2 * F];

            for (int i = 0; i < 2 * F; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            int count = 0;
            StringTokenizer st;
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String friend1 = st.nextToken();
                String friend2 = st.nextToken();

                if (!ids.containsKey(friend1)) {
                    ids.put(friend1, count++);
                }
                if (!ids.containsKey(friend2)) {
                    ids.put(friend2, count++);
                }

                int id1 = ids.get(friend1);
                int id2 = ids.get(friend2);
                union(id1, id2);

                sb.append(size[find(id1)]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (size[a] < size[b]) {
                parent[a] = b;
                size[b] += size[a];
            } else {
                parent[b] = a;
                size[a] += size[b];
            }
        }
    }
}
