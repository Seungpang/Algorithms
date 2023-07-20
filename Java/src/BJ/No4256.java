package BJ;
// 트리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No4256 {

    static int[] pre, in;
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            pre = new int[n];
            in = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                pre[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                in[i] = Integer.parseInt(st.nextToken());
            }

            findPostOrder(0, 0, n - 1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void findPostOrder(int rootIdx, int start, int end) {
        if (rootIdx >= n) {
            return;
        }

        int rootValue = pre[rootIdx];

        for (int idx = start; idx <= end; idx++) {
            if (rootValue == in[idx]) {
                findPostOrder(rootIdx + 1, start, idx);
                findPostOrder(rootIdx + idx + 1 - start, idx + 1, end);
                sb.append(rootValue).append(" ");
                return;
            }
        }
    }
}
