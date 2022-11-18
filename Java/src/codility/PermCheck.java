package codility;

public class PermCheck {

    public static void main(String[] args) {
        final PermCheck permCheck = new PermCheck();
        int[] A = {4, 1, 3, 2};
        System.out.println(permCheck.solution(A));
    }

    public int solution(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i) {
                return 0;
            }
        }
        return 1;
    }
}
