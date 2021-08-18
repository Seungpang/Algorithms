package Test;

public class test4 {

    public static void main(String[] args) {
        test4 a = new test4();
        int[][] v = {{1, 4}, {3, 4}, {1, 10}};

        System.out.println(a.solution(v));
    }

    public int[] solution(int[][] v) {
        int[] answer = new int[2];

        answer[0] = v[0][0] ^ v[1][0] ^ v[2][0];
        System.out.println("answer[0]: " + answer[0]);
        answer[1] = v[0][1] ^ v[1][1] ^ v[2][1];
        System.out.println("answer[1]: " + answer[1]);

        return answer;
    }
}
