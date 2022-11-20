package codility;

public class CountDiv {

    public static void main(String[] args) {
        final CountDiv countDiv = new CountDiv();
        System.out.println(countDiv.solution(6, 11, 2)); //3
    }

    public int solution(int A, int B, int K) {
        if (A % K == 0) {
            return B / K - A / K + 1;
        }
        return B / K - A / K;
    }
}
