package codility;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

    public static void main(String[] args) {
        final FrogRiverOne frogRiverOne = new FrogRiverOne();
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(frogRiverOne.solution(5, A)); //6
    }

    public int solution(int X, int[] A) {
        Set<Integer> marks = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X) {
                marks.add(A[i]);
                if (marks.size() >= X) {
                    return i;
                }
            }
        }

        return -1;
    }
}
