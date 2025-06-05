package BJ;
// AC

import java.util.Scanner;

public class No5430 {

    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        StringBuilder sb = new StringBuilder();
        while (T-->0){
            String commands =  sc.nextLine();
            int n = Integer.parseInt(sc.nextLine());
            String line = sc.nextLine().trim();

            int[] nums = new int[n];
            if (n > 0) {
                String body = line.substring(1, line.length() - 1);
                String[] parts = body.split(",");
                for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(parts[i]);
            }

            int left = 0;
            int right = n - 1;
            boolean reversed = false;
            boolean fail = false;
            for (int i = 0; i < commands.length(); i++) {
                char c= commands.charAt(i);
                if (c == 'R') {
                    reversed = !reversed;
                } else {
                    if (left > right) {
                        fail = true;
                        break;
                    }
                    if (!reversed) left++;
                    else right--;
                }
            }

            if (fail) {
                sb.append("error\n");
                continue;
            }

            sb.append("[");
            if (left <= right) {
                if (!reversed) {
                    for (int i = left; i <= right; i++) {
                        if (i > left) sb.append(',');
                        sb.append(nums[i]);
                    }
                } else {
                    for (int i = right; i >= left; i--) {
                        if (i < right) sb.append(',');
                        sb.append(nums[i]);
                    }
                }
            }
            sb.append("]\n");
        }

        System.out.println(sb);
    }
}
