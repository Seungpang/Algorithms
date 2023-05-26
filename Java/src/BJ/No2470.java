package BJ;
// 두 용액

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        int left = 0;
        int right = a.length - 1;
        int ml = 0;
        int mr = 0;
        long min = Long.MAX_VALUE;
        while (left < right) {
            long sum = a[left] + a[right];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                ml = left;
                mr = right;
            }
            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(a[ml] + " " + a[mr]);
    }
}
