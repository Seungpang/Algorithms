package BJ;
// 연산자 끼워넣기 (3)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class No15659 {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4]; // +, -, *, /
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Integer> operatorList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth) {
        if (depth == N - 1) {
            int result = calculate();
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                operatorList.add(i);
                dfs(depth + 1);
                operatorList.remove(operatorList.size() - 1);
                operators[i]++;
            }
        }
    }

    static int calculate() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(Arrays.stream(numbers).boxed().toArray(Integer[]::new)));
        List<Integer> ops = new ArrayList<>(operatorList);

        for (int i = 0; i < ops.size(); i++) {
            if (ops.get(i) == 2 || ops.get(i) == 3) {
                int res = operate(nums.get(i), nums.get(i + 1), ops.get(i));
                nums.set(i, res);
                nums.remove(i + 1);
                ops.remove(i);
                i--;
            }
        }

        int result = nums.get(0);
        for (int i = 0; i < ops.size(); i++) {
            result = operate(result, nums.get(i + 1), ops.get(i));
        }

        return result;
    }

    static int operate(int a, int b, int op) {
        switch (op) {
            case 0: return a + b;
            case 1: return a - b;
            case 2: return a * b;
            case 3: return a / b;
            default: return 0;
        }
    }
}
