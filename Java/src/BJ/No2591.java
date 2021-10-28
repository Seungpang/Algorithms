package BJ;
//분할 정복-이분탐 색
//숫자카드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2591 {

    static boolean binary_search(int[] a, int target) {
        int n = a.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] == target) {
                return true;
            } else if (a[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        line = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(line[i]);
            boolean result = binary_search(a, target);
            if (result) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }
}
