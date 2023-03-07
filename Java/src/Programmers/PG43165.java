package Programmers;

public class PG43165 {

    public static void main(String[] args) {
        final PG43165 pg43165 = new PG43165();
        System.out.println(pg43165.solution(new int[]{4, 1, 2, 1}, 4));
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer = dfs(numbers, target, numbers[0], 1) + dfs(numbers, target, -numbers[0], 1);
        
        return answer;
    }

    private int dfs(int[] numbers, int target, int sum, int depth) {
        if (numbers.length == depth) {
            if (target == sum) {
                return 1;
            } else {
                return 0;
            }
        }

        int result = 0;
        result += dfs(numbers, target, sum + numbers[depth], depth + 1);
        result += dfs(numbers, target, sum - numbers[depth], depth + 1);

        return result;
    }
}
