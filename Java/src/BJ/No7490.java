package BJ;
// 0 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No7490 {

    static List<String> results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            results = new ArrayList<>();

            go("1", 2, N);

            Collections.sort(results);
            for (String result : results) {
                System.out.println(result);
            }

            System.out.println();
        }
    }

    static void go(String expr, int num, int N) {
        if (num > N) {
            if (evaluateExpression(expr) == 0) {
                results.add(expr);
            }
            return;
        }

        go(expr + "+" + num, num + 1, N);
        go(expr + "-" + num, num + 1, N);
        go(expr + " " + num, num + 1, N);
    }

    static long evaluateExpression(String expr) {
        expr = expr.replaceAll(" ", "");
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        StringBuilder num = new StringBuilder();
        operators.add('+');

        for (char ch : expr.toCharArray()) {
            if (ch == '+' || ch == '-') {
                numbers.add(Long.parseLong(num.toString()));
                num = new StringBuilder();
                operators.add(ch);
            } else {
                num.append(ch);
            }
        }

        numbers.add(Long.parseLong(num.toString()));

        long result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (operators.get(i) == '+') {
                result += numbers.get(i);
            } else {
                result -= numbers.get(i);
            }
        }

        return result;
    }
}
