package BJ;
// 구간 나누기 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No13397 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0;
        int high = Arrays.stream(nums).max().getAsInt() - Arrays.stream(nums).min().getAsInt();
        int result = high;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canDivide(nums, M, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean canDivide(int[] nums, int m, int maxScore) {
        int count = 1;
        int minVal = nums[0];
        int maxVal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);

            if (maxVal - minVal > maxScore) {
                count++;
                minVal = nums[i];
                maxVal = nums[i];

                if (count > m) {
                    return false;
                }
            }
        }

        return count <= m;
    }
}
