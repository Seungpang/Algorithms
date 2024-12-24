package BJ;
// 홀수 홀릭 호석

import java.util.Scanner;

public class No20164 {

    static int minOdd = Integer.MAX_VALUE;
    static int maxOdd = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine().trim();
        dfs(N, 0);
        System.out.println(minOdd + " " + maxOdd);
    }

    static void dfs(String num, int oddCount) {
        oddCount += countOddDigits(num);
        //수가 한 자리이면 더 이상 아무것도 하지 못하고 종료한다.
        if (num.length() == 1) {
            minOdd = Math.min(minOdd, oddCount);
            maxOdd = Math.max(maxOdd, oddCount);
            return;
        }
        // 수가 두 자리이면 2개로 나눠서 합을 구하여 새로운 수로 생각한다.
        if (num.length() == 2) {
            int sum = (num.charAt(0) - '0') + (num.charAt(1) - '0');
            dfs(String.valueOf(sum), oddCount);
        } else {
            //수가 세 자리 이상이면 임의의 위치에서 끊어서 3개의 수로 분할하고, 3개를 더한 값을 새로운 수로 생각한다
            for (int i = 1; i < num.length(); i++) {
                for (int j = i + 1; j < num.length(); j++) {
                    int part1 = Integer.parseInt(num.substring(0, i));
                    int part2 = Integer.parseInt(num.substring(i, j));
                    int part3 = Integer.parseInt(num.substring(j));
                    int sum = part1 + part2 + part3;
                    dfs(String.valueOf(sum), oddCount);
                }
            }
        }
    }

    static int countOddDigits(String num) {
        int count = 0;
        for (char c : num.toCharArray()) {
            if ((c - '0') % 2 == 1) {
                count++;
            }
        }
        return count;
    }
}
