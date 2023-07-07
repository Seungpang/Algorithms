package Programmers;
// 소수 찾기

import java.util.ArrayList;
import java.util.List;

public class PG42839 {
    static List<Integer> arr = new ArrayList<>();
    static boolean[] check = new boolean[7];

    public static void main(String[] args) {
        PG42839 pg42839 = new PG42839();
        System.out.println(pg42839.solution("17")); // 3
    }

    public int solution(String numbers) {
        int answer = 0;
        for (int i = 0; i < numbers.length(); i++) {
            dfs(numbers, "", i + 1);
        }

        for (int i = 0; i < arr.size(); i++) {
            if (isPrime(arr.get(i))) {
                answer++;
            }
        }

        return answer;
    }

    void dfs(String str, String result, int index) {
        if (result.length() == index) {
            int num = Integer.parseInt(result);
            if (!arr.contains(num)) {
                arr.add(num);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (!check[i]) {
                check[i] = true;
                result += str.charAt(i);
                dfs(str, result, index);
                check[i] = false;
                result = result.substring(0, result.length() - 1);
            }
        }
    }

    boolean isPrime(int n) {
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
