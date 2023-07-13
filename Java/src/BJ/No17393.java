package BJ;
// 다이나믹 롤러
import java.util.Scanner;

public class No17393 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] A = new long[n];
        long[] B = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextLong();
        }

        for (int i = 0; i < n; i++) {
            B[i] = sc.nextLong();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (A[i] < B[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            int temp = right - i;
            sb.append(temp).append(" ");
        }

        System.out.println(sb);
    }
}
