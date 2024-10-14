package BJ;
// 나무 위의 빗물

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No17073 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long W = Long.parseLong(st.nextToken());

        List<Integer>[] tree = new ArrayList[N + 1];
        int[] degree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            tree[U].add(V);
            tree[V].add(U);

            degree[U]++;
            degree[V]++;
        }

        int leafCount = 0;
        for (int i = 2; i <= N; i++) {
            if (degree[i] == 1) {
                leafCount++;
            }
        }

        double result = (double) W / leafCount;

        System.out.printf("%.10f\n", result);
    }
}
