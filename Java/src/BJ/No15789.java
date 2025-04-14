package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No15789 {

    static int[] parent;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        size = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            union(X, Y);
        }

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ctpRoot = find(C);
        int hansolRoot = find(H);

        List<Integer> componentSizes = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (find(i) == i && i != hansolRoot) {
                componentSizes.add(size[i]);
            }
        }

        componentSizes.sort(Collections.reverseOrder());

        int ctpPower = size[ctpRoot];
        for (int i = 0; i < Math.min(K, componentSizes.size()); i++) {
            ctpPower += componentSizes.get(i);
        }

        System.out.println(ctpPower);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (size[x] < size[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parent[y] = x;
            size[x] += size[y];
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
}
