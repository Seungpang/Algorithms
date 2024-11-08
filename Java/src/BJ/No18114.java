package BJ;
// 블랙 프라이데이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No18114 {

    static int N, C;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        for (int num : nums) {
            if (num == C) {
                System.out.println(1);
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j=i+1; j<N; j++) {
                if (nums[i] + nums[j] == C) {
                    System.out.println(1);
                    return;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int target = C - nums[i];
            int left = i + 1, right = N - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    System.out.println(1);
                    return;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(0);
    }
}
