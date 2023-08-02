package BJ;
// 소-난다!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No19699 {

    static int N, M;
    static int[] arr;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);

        if (result.size() == 0) {
            System.out.println(-1);
            return;
        }
        Collections.sort(result);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    static void dfs(int sum, int index, int count) {
        if (count == M) {
            if (isPrime(sum)) {
                if (!result.contains(sum)) {
                    result.add(sum);
                }
            }
        }
        if (index >= N) {
            return;
        }
        dfs(sum + arr[index], index + 1, count + 1);
        dfs(sum, index + 1, count);
    }

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
