package BJ;
// 호텔 방 번호

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class No5671 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] nums = line.split(" ");
            int N = Integer.parseInt(nums[0]);
            int M = Integer.parseInt(nums[1]);
            int result = 0;
            for (int i = N; i <= M; i++) {
                if (isPossible(i)) {
                    result++;
                }
            }

            System.out.println(result);
        }
    }

    static boolean isPossible(int num) {
        String s = String.valueOf(num);
        Set<Character> nums = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!nums.add(c)) {
                return false;
            }
        }

        return true;
    }
}
