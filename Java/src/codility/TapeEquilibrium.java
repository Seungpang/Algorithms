package codility;

public class TapeEquilibrium {

    public static void main(String[] args) {
        final TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        int[] A = {3, 1, 2, 4, 3};
        System.out.println(tapeEquilibrium.solution(A)); //1
    }

    public int solution(int[] A) {
        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }

        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            sum += A[i];
            result = Math.min(result, Math.abs(sum - (totalSum - sum)));
        }
        return result;
    }
}
