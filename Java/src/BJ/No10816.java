package BJ;
//분할 정복-이분 탐색
//숫자 카드2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        line = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(line[i]);
            int l = lower_bound(a, target);
            int r = upper_bound(a, target);
            if (l == -1) {
                sb.append("0 ");
            } else {
                sb.append(r - l + 1).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static int upper_bound(int[] a, int target) {
        int n = a.length;
        int l = 0;
        int r = n - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] == target) {
                ans = mid;
                l = mid + 1;
            } else if (a[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    static int lower_bound(int[] a, int target) {
        int n = a.length;
        int l = 0;
        int r = n - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] == target) {
                ans = mid;
                r = mid - 1;
            } else if (a[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
